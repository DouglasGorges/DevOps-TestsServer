package com.fullstack.vehicles.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Long timeStamp;
    private Integer status;
    private String message;

    public StandardError() {
    }

    public StandardError(Long timeStamp, Integer status, String message) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
