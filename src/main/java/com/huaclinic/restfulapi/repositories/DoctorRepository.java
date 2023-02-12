package com.huaclinic.restfulapi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.huaclinic.restfulapi.models.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
    Doctor findByUsername(String username);
}
