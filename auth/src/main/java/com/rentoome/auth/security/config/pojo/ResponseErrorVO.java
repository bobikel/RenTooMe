/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.security.config.pojo;

import org.springframework.util.ObjectUtils;

/**
 *
 * @author DYNABOOK
 */
public class ResponseErrorVO {
    private String code;
    private String message;
    private String description;
    public ResponseErrorVO(String code, String message) {
        this.code = code;
        this.message = message;
        this.description = message;
    }
    public ResponseErrorVO(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getDescription() {
        return ObjectUtils.isEmpty(description) ? message : description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
