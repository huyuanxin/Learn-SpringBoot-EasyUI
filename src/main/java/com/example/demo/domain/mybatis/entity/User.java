package com.example.demo.domain.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private long Uid;
    private String UserName;
    private String Password;

    @JsonProperty("Uid")
    public long getUid() {
        return Uid;
    }

    public void setUid(long uid) {
        this.Uid = uid;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + Uid +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
