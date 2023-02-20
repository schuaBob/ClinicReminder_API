package com.huaclinic.restfulapi.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import java.io.Serializable;

@Embeddable
public class DoctorPatientKey implements Serializable {
    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "patient_id")
    private Integer patientId;
    
    public DoctorPatientKey() {

    }
    
    public DoctorPatientKey(Integer doctorId, Integer patientId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }
    
}
