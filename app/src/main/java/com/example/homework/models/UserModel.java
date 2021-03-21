package com.example.homework.models;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String name;
    private String company;
    private String avatar_url;

    public UserModel(String name, String company, String avatar_url) {
        this.name = name != null ? name : "/";
        this.company = company != null ? company : "/";
        this.avatar_url = avatar_url != null ? avatar_url : "/";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
