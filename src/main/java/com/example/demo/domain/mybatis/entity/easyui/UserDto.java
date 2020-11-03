package com.example.demo.domain.mybatis.entity.easyui;

import com.example.demo.domain.mybatis.entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;

public class UserDto {
    HttpStatus httpStatus;
    long total;
    List<User> rows;
    String Message;

    public UserDto(HttpStatus httpStatus, long total, List<User> rows, String message) {
        this.httpStatus = httpStatus;
        this.total = total;
        this.rows = rows;
        Message = message;
    }

    public UserDto(HttpStatus httpStatus, List<User> rows, String message) {
        this.httpStatus = httpStatus;
        this.rows = rows;
        this.total = rows.size();
        Message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
