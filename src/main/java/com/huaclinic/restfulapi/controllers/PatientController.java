package com.huaclinic.restfulapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.huaclinic.restfulapi.services.CustomUserDetails;
import com.huaclinic.restfulapi.payload.response.ReminderRes;
import java.util.LinkedList;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;
import com.huaclinic.restfulapi.repositories.ReminderRepository;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private ReminderRepository reminderRepo;

    @GetMapping("/reminders")
    public List<ReminderRes> getReminders() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        List<ReminderRes> res = new LinkedList<ReminderRes>();
        reminderRepo.findAllByPatientId(userDetails.getId(), false).forEach((reminder) -> {
            res.add(new ReminderRes((Integer) reminder[0], (String) reminder[1], (String) reminder[2], reminder[3].toString(), (boolean) reminder[4]));
        });
        return res;
    }
}
