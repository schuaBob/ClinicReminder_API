package com.huaclinic.restfulapi.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import com.huaclinic.restfulapi.repositories.DoctorRepository;
import com.huaclinic.restfulapi.models.DoctorPatient;
import com.huaclinic.restfulapi.services.CustomUserDetails;
import com.huaclinic.restfulapi.payload.response.PatientRes;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/list")
public class DoctorPatientController {
    @Autowired
    DoctorRepository doctorRepo;

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
}
