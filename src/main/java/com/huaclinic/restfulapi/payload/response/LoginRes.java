package com.huaclinic.restfulapi.payload.response;

import java.util.List;

public class LoginRes {
    private Integer id;
    private String username;
    private String name;
    private List<String> permissions;
    private String jwt;
    public LoginRes(Integer id, String username, String name, List<String> permissions, String jwt) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.permissions = permissions;
        this.jwt = jwt;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public String getName() {
        return this.name;
    }
}
