package com.huaclinic.restfulapi.payload.request;

public class ReminderReq {
    private String description;
    private Integer patient;
    private Integer duration;
    private String priority;
    private boolean done;

    public ReminderReq(boolean done) {
        this.done = done;
    }

    public ReminderReq(String description, Integer patient, Integer duration, String priority) {
        this.description = description;
        this.patient = patient;
        this.duration = duration;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
