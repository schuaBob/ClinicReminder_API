package com.huaclinic.restfulapi.models;

import jakarta.persistence.Entity;

@Entity
public class Doctor extends User{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
