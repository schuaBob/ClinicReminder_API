package com.huaclinic.restfulapi.payload.response;

public class ReminderRes {
    private Integer id;
    private String description;
    private String priority;
    private String duetime;
    private boolean done;
    
    public ReminderRes(Integer id, String description, String priority, String duetime, boolean done) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.duetime = duetime;
        this.done = done;
    }
    public boolean getDone() {
        return this.done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public Integer getId() {
        return this.id;
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
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getDuetime() {
        return duetime;
    }
    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }
    
}
