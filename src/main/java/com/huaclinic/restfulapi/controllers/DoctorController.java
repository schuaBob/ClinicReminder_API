package com.huaclinic.restfulapi.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.huaclinic.restfulapi.repositories.DoctorRepository;
import com.huaclinic.restfulapi.models.DoctorPatient;
import com.huaclinic.restfulapi.services.CustomUserDetails;
import com.huaclinic.restfulapi.payload.response.PatientRes;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import java.util.Date;
import org.springframework.security.core.context.SecurityContextHolder;
import com.huaclinic.restfulapi.payload.response.AllReminderRes;
import com.huaclinic.restfulapi.repositories.ReminderRepository;
import com.huaclinic.restfulapi.payload.response.HistoryRes;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepo;
    @Autowired
    private ReminderRepository reminderRepo;
    
    @GetMapping("/patients")
    public List<PatientRes> listPatients() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<DoctorPatient> relation = doctorRepo.findById(userDetails.getId()).get().getDoctorPatients();
        List<PatientRes> res = new LinkedList<PatientRes>();
        relation.forEach((dp)->{
            res.add(new PatientRes(dp.getPatient().getId(),dp.getPatient().getName()));
        });
        return res;
    }
    @GetMapping("/reminders")
    public List<AllReminderRes> getAllReminders() {
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

    @GetMapping("/reminders/history")
    public List<HistoryRes> getRemindersHistory(@RequestParam(name = "id") String patientId) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<HistoryRes> res = new LinkedList<HistoryRes>();
        reminderRepo.findAllinLast7days(userDetails.getId(), Integer.parseInt(patientId)).forEach((record) -> {
            String date = ((Date)record[0]).toString();
            res.add(new HistoryRes(date, (Long)record[1]));
        });
        return res;
    }
}
