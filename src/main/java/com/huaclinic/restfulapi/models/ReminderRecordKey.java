package com.huaclinic.restfulapi.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;
import java.io.Serializable;

@Embeddable
public class ReminderRecordKey implements Serializable {

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "patient_id")
    private Integer patientId;
    
    @Column(name = "reminder_id")
    private Integer reminderId;
    
    public ReminderRecordKey() {
    }
    
    public ReminderRecordKey(Integer doctorId, Integer patientId, Integer reminderId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.reminderId = reminderId;
    }

    

    public Integer getReminderId() {
        return reminderId;
    }

    public void setReminderId(Integer reminderId) {
        this.reminderId = reminderId;
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
