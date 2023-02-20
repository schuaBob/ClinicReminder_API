package com.huaclinic.restfulapi.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.huaclinic.restfulapi.repositories.DoctorPatientRepository;
import com.huaclinic.restfulapi.repositories.ReminderRepository;
import com.huaclinic.restfulapi.repositories.ReminderRecordRepository;
import com.huaclinic.restfulapi.services.CustomUserDetails;
import com.huaclinic.restfulapi.models.DoctorPatient;
import com.huaclinic.restfulapi.models.DoctorPatientKey;
import com.huaclinic.restfulapi.models.Priority;
import com.huaclinic.restfulapi.models.Reminder;
import com.huaclinic.restfulapi.models.ReminderRecord;
import com.huaclinic.restfulapi.payload.request.ReminderReq;
import com.huaclinic.restfulapi.payload.response.MessageRes;
import com.huaclinic.restfulapi.payload.response.AllReminderRes;
import com.huaclinic.restfulapi.payload.response.HistoryRes;

import java.util.List;
@RestController
@RequestMapping("/api/reminder")
public class ReminderController {
    @Autowired
    private ReminderRepository reminderRepo;
    @Autowired
    private DoctorPatientRepository dpRepo;
    @Autowired
    private ReminderRecordRepository rrRepo;

    @GetMapping()
    public List<AllReminderRes> getAllReminder() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<AllReminderRes> res = new LinkedList<AllReminderRes>();
        reminderRepo.findAllOrderByPriorityDESC(userDetails.getId(), false).forEach((record) -> {
            Long highLong = record[2] == null ? 0 : (Long)record[2];
            Long midLong = record[3] == null ? 0 : (Long)record[3];
            Long lowLong = record[4] == null ? 0 : (Long)record[4];
            res.add(new AllReminderRes((Integer)record[0], (String)record[1], highLong, midLong, lowLong));
        });
        return res;
    }

    @GetMapping("/history")
    public List<HistoryRes> getHistory(@RequestParam(name = "id") String patientId) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<HistoryRes> res = new LinkedList<HistoryRes>();
        reminderRepo.findAllinLast7days(userDetails.getId(), Integer.parseInt(patientId)).forEach((record) -> {
            String date = ((Date)record[0]).toString();
            res.add(new HistoryRes(date, (Long)record[1]));
        });
        return res;
    }

    @PostMapping()
    public MessageRes createReminder(@RequestBody ReminderReq rRq) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, rRq.getDuration());
        Reminder reminder = new Reminder(rRq.getDescription(), rRq.getDuration(), Priority.valueOf(rRq.getPriority()), calendar.getTime());
        reminderRepo.save(reminder);
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DoctorPatient dp = dpRepo.findById(new DoctorPatientKey(userDetails.getId(), rRq.getPatient())).get();
        ReminderRecord rr = new ReminderRecord(dp,reminder);
        rrRepo.save(rr);        
        
        MessageRes res = new MessageRes("good");
        return res;
    }

}
