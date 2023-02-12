package com.huaclinic.restfulapi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.huaclinic.restfulapi.models.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
    Patient findByUsername(String username);
}
