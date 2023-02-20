package com.huaclinic.restfulapi.payload.response;

public class AllReminderRes {
    private Integer patient_id;
    private String pname;
    private Long high;
    private Long middle;
    private Long low;
    public AllReminderRes(Integer patient_id, String pname, Long high, Long middle, Long low) {
        this.patient_id = patient_id;
        this.pname = pname;
        this.high = high;
        this.middle = middle;
        this.low = low;
    }
    public Integer getPatient_id() {
        return patient_id;
    }
    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Long getHigh() {
        return high;
    }
    public void setHigh(Long high) {
        this.high = high;
    }
    public Long getMiddle() {
        return middle;
    }
    public void setMiddle(Long middle) {
        this.middle = middle;
    }
    public Long getLow() {
        return low;
    }
    public void setLow(Long low) {
        this.low = low;
    }
    
    
}
