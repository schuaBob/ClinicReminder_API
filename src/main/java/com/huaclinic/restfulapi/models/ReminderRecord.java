package com.huaclinic.restfulapi.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.GenerationType;

@Entity
public class ReminderRecord {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EmbeddedId
    private ReminderRecordKey pk;


    @ManyToOne
    @MapsId("doctorpatientId")
    @JoinColumns({
        @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id"),
        @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    })
    private DoctorPatient doctorpatient;

    @ManyToOne
    @MapsId("reminderId")
    @JoinColumn(name = "reminder_id")
    private Reminder reminder;


}
