package com.huaclinic.restfulapi.payload.response;

public class HistoryRes {
    private String date;
    private Long count;
    
    public HistoryRes(String date, Long count) {
        this.date = date;
        this.count = count;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    
}
