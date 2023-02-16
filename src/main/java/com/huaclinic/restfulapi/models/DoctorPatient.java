package com.huaclinic.restfulapi.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "doctor_patient")
public class DoctorPatient {

    @EmbeddedId
    private DoctorPatientKey pk;

    public DoctorPatient(Doctor doctor, Patient patient) {
        this.pk = new DoctorPatientKey(doctor.getId(), patient.getId());
        this.doctor = doctor;
        this.patient = patient;
    }

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne
    @MapsId("patientId")
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @OneToMany(mappedBy = "doctorpatient")
    private Set<ReminderRecord> reminderRecords;

}
