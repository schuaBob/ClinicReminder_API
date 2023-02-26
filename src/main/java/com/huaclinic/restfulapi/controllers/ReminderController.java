package com.huaclinic.restfulapi.controllers;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.huaclinic.restfulapi.payload.response.MessageRes;;

@RestController
@RequestMapping("/api/reminder")
public class ReminderController {
    @Autowired
    private ReminderRepository reminderRepo;
    @Autowired
    private DoctorPatientRepository dpRepo;
    @Autowired
    private ReminderRecordRepository rrRepo;

    @PostMapping()
    public MessageRes createReminder(@RequestBody ReminderReq rRq) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY, rRq.getDuration());
        Reminder reminder = new Reminder(rRq.getDescription(), rRq.getDuration(), Priority.valueOf(rRq.getPriority()),
                calendar.getTime());
        reminderRepo.save(reminder);
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        DoctorPatient dp = dpRepo.findById(new DoctorPatientKey(userDetails.getId(), rRq.getPatient())).get();
        ReminderRecord rr = new ReminderRecord(dp, reminder);
        rrRepo.save(rr);
        MessageRes res = new MessageRes("good");
        return res;
    }

    @PutMapping("/{id}")
    public MessageRes updateReminder(@RequestBody ReminderReq rRq, @PathVariable("id") Integer id) {
        reminderRepo.findById(id).ifPresent((reminder) -> {
            reminder.setDone(rRq.isDone());
            reminderRepo.save(reminder);
        });

        MessageRes res = new MessageRes("good");
        return res;
    }

}
