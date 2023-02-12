package com.huaclinic.restfulapi.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Column;
import java.io.Serializable;

@Embeddable
public class ReminderRecordKey implements Serializable {

    @Embedded
    private DoctorPatientKey doctorpatientId;
    
    @Column(name = "reminder_id")
    private Integer reminderId;

}
