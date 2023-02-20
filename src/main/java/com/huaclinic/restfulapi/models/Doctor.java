package com.huaclinic.restfulapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Doctor extends Users {
    private String dname;

    public Doctor() {
        super();
    }

    public Doctor(String username, Set<Permission> permission, String password, String name) {
        super(username, permission, password, name);
        this.dname = name;
    }

    public String getName() {
        return dname;
    }

    public void setName(String name) {
        this.dname = name;
    }

    @OneToMany(mappedBy = "doctor")
    private Set<DoctorPatient> doctorPatients;

    public Set<DoctorPatient> getDoctorPatients() {
        return this.doctorPatients;
    }
}
