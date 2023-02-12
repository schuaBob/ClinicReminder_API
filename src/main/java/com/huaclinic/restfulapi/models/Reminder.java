package com.huaclinic.restfulapi.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Integer duration;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CreationTimestamp()
    @Column(name = "create_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date dueTime;

    private Boolean done = false;

}
