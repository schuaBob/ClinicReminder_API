package com.huaclinic.restfulapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Patient extends Users{
    private String pname;
    
    public Patient() {
        super();
    }
    public Patient(String username, Set<Permission> permission, String password, String name) {
        super(username, permission, password, name);
        this.pname = name;
    }
    public String getName() {
        return pname;
    }
    public void setName(String name) {
        this.pname = name;
    }

    @OneToMany(mappedBy = "patient")
    private Set<DoctorPatient> doctorPatients;
}
