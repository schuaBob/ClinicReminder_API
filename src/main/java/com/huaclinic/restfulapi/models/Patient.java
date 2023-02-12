package com.huaclinic.restfulapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Patient extends User{
    private String name;
    
    public Patient(String username, Set<Permission> permission, String password, String name) {
        super(username, permission, password);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "patient")
    private Set<DoctorPatient> doctorPatients;
}
