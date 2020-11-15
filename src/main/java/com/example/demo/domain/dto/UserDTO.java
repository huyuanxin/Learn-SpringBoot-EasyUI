package com.example.demo.domain.dto;

import com.example.demo.domain.entity.User;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * @author yuanxin
 * @create 2020/11/11 11:25
 */
public class UserDTO {
    HttpStatus httpStatus;
    Long total;
    List<User> rows;
    String message;

    public UserDTO(HttpStatus httpStatus, long total, List<User> rows, String message) {
        this.httpStatus = httpStatus;
        this.total = total;
        this.rows = rows;
        this.message = message;
    }

    public UserDTO(HttpStatus httpStatus, List<User> rows, String message) {
        this.httpStatus = httpStatus;
        this.rows = rows;
        this.total = (long) rows.size();
        this.message = message;
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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "httpStatus=" + httpStatus +
                ", total=" + total +
                ", rows=" + rows +
                ", Message='" + message + '\'' +
                '}';
    }
}
