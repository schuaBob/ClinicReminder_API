package com.huaclinic.restfulapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.huaclinic.restfulapi.models.DoctorPatient;
import com.huaclinic.restfulapi.models.DoctorPatientKey;

public interface DoctorPatientRepository extends CrudRepository<DoctorPatient, DoctorPatientKey> {
}
