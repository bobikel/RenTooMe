/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.security.config.pojo;

/**
 *
 * @author DYNABOOK
 * @param <T>
 */
public class ResponseVO<T> {

    private String status;
    private String result;
    private ResponseErrorVO error;
    private T data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public ResponseErrorVO getError() {
        return error;
    }

    public void setError(ResponseErrorVO error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }
}
