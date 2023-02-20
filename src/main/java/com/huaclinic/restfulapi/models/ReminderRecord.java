package com.huaclinic.restfulapi.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class ReminderRecord {
    @EmbeddedId
    private ReminderRecordKey pk;
    
    @ManyToOne
    @MapsId("pk")
    @JoinColumns({
        @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id"),
        @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    })
    private DoctorPatient doctorpatient;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "reminder_id")
    private Reminder reminder;
    
    public ReminderRecord() {
    }
    
    public ReminderRecord(DoctorPatient doctorpatient, Reminder reminder) {
        this.pk = new ReminderRecordKey(doctorpatient.getDoctor().getId(), doctorpatient.getPatient().getId(), reminder.getId());
        this.doctorpatient = doctorpatient;
        this.reminder = reminder;
    }

    public ReminderRecordKey getPk() {
        return pk;
    }

    public void setPk(ReminderRecordKey pk) {
        this.pk = pk;
    }

    public DoctorPatient getDoctorpatient() {
        return doctorpatient;
    }

    public void setDoctorpatient(DoctorPatient doctorpatient) {
        this.doctorpatient = doctorpatient;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
    


}
