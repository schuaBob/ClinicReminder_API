package com.huaclinic.restfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaclinic.restfulapi.models.Permission;
import com.huaclinic.restfulapi.models.Doctor;
import com.huaclinic.restfulapi.repositories.DoctorRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoctorRepository doctorRepo;

    @GetMapping()
    public Iterable<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    // @PostMapping()
    // public String addUser(@RequestBody User user) {
    //     System.out.println("get");
    //     user.setPermission(Permission.DOCTOR);
    //     userRepo.save(user);
    //     return "hello";
    // }
}
