package com.huaclinic.restfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaclinic.restfulapi.models.Permission;
import com.huaclinic.restfulapi.models.Doctor;
import com.huaclinic.restfulapi.repositories.UsersRepository;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersRepository userRepo;

    @GetMapping()
    public String createUsers() {

        for (int i = 1; i <= 1; i++) {
            Doctor doctor = new Doctor(
                    String.format("doctor%d", i),
                    new HashSet<Permission>(Arrays.asList(Permission.DOCTOR)),
                    String.format("doctor%d", i),
                    String.format("Doctor #%d", i));
            userRepo.save(doctor);
            // Set<Permission> permission = new
            // HashSet<Permission>(Arrays.asList(Permission.PATIENT));
            // for(int j = 1; j<=1; j++) {
            // // for (int j = 1 + 40 * (i - 1); j <= 40 * i; j++) {
            // Patient patient = new Patient(
            // String.format("patient%d", j),
            // permission,
            // String.format("patient%d", j),
            // String.format("Patient #%d", j));
            // patientRepo.save(patient);
            // doctorpatientRepo.save(new DoctorPatient(doctor, patient));
            // }
        }
        return "good";
    }

    // @PostMapping()
    // public String addUser(@RequestBody User user) {
    // System.out.println("get");
    // user.setPermission(Permission.DOCTOR);
    // userRepo.save(user);
    // return "hello";
    // }
}
