package com.huaclinic.restfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huaclinic.restfulapi.models.Permission;
import com.huaclinic.restfulapi.models.Doctor;
import com.huaclinic.restfulapi.models.DoctorPatient;
import com.huaclinic.restfulapi.models.Patient;
import com.huaclinic.restfulapi.repositories.DoctorPatientRepository;
import com.huaclinic.restfulapi.repositories.DoctorRepository;
import com.huaclinic.restfulapi.repositories.PatientRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired
    private PatientRepository patientRepo;
    @Autowired
    private DoctorPatientRepository doctorpatientRepo;

    @GetMapping()
    public String getUsers() {
        // for (int i = 1; i <= 500; i++) {
        //     Doctor doctor = new Doctor(
        //         String.format("doctor%d", i),
        //         new HashSet<Permission>(Arrays.asList(Permission.DOCTOR)),
        //         String.format("doctor%d", i),
        //         String.format("Doctor #%d", i));
        //         doctorRepo.save(doctor);
        //     Set<Permission> permission = new HashSet<Permission>(Arrays.asList(Permission.PATIENT));
        //     for (int j = 1 + 40 * (i - 1); j <= 40 * i; j++) {
        //         Patient patient = new Patient(
        //                 String.format("patient%d", j),
        //                 permission,
        //                 String.format("patient%d", j),
        //                 String.format("Patient #%d", j));
        //         patientRepo.save(patient);
        //         doctorpatientRepo.save(new DoctorPatient(doctor, patient));
        //     }
        // }
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
