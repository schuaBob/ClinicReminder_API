package com.huaclinic.restfulapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Doctor extends User{
    private String name;
    
    public Doctor(String username, Set<Permission> permission, String password, String name) {
        super(username, permission, password);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "doctor")
    private Set<DoctorPatient> doctorPatients;
}
