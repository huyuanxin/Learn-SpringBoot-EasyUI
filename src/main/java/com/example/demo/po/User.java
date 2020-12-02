package com.example.demo.po;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
public class User {

    private long uid = 0;
    private String userName = "";
    private String password = "";

    @JsonProperty("Uid")
    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @JsonProperty("UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", UserName='" + userName + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return uid == user.uid && Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, userName, password);
    }
}
