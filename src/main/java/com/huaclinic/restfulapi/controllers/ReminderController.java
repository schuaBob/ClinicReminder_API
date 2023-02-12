package com.huaclinic.restfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huaclinic.restfulapi.repositories.ReminderRepository;
import com.huaclinic.restfulapi.models.Reminder;


@RestController
@RequestMapping("/reminder")
public class ReminderController {
    @Autowired
    private ReminderRepository reminderRepo;

    @GetMapping()
    public Iterable<Reminder> getDoctors() {
        return reminderRepo.findAll();
    }

    // @PostMapping()
    // public String addUser(@RequestBody User user) {
    // System.out.println("get");
    // user.setPermission(Permission.DOCTOR);
    // userRepo.save(user);
    // return "hello";
    // }
}
