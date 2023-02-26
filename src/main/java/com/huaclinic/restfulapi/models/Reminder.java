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

import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Set;
@Entity
public class Reminder {

    public Reminder() {

    }
    public Reminder(String description, Integer duration, Priority priority, Date dueTime) {
        this.description = description;
        this.duration = duration;
        this.priority = priority;
        this.dueTime = dueTime;
    }

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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "done_time", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Date doneTime;

    @OneToMany(mappedBy = "reminder")
    private Set<ReminderRecord> reminderRecords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDueTime() {
        return dueTime;
    }

    public void setDueTime(Date dueTime) {
        this.dueTime = dueTime;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Date getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Date doneTime) {
        this.doneTime = doneTime;
    }

    public Set<ReminderRecord> getReminderRecords() {
        return reminderRecords;
    }

    public void setReminderRecords(Set<ReminderRecord> reminderRecords) {
        this.reminderRecords = reminderRecords;
    }
    
    
}
