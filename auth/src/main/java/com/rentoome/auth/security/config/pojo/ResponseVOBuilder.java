/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.security.config.pojo;

/**
 *
 * @author DYNABOOK
 */
public class ResponseVOBuilder<T> {

    private final ResponseVO<T> responseVO = new ResponseVO<>();

    private ResponseVOBuilder<T> result(String result) {
        responseVO.setResult(result);
        return this;
    }

    private ResponseVOBuilder<T> status(String status) {
        responseVO.setStatus(status);
        return this;
    }

    public ResponseVOBuilder<T> success() {
        return new ResponseVOBuilder<T>().result("Succeed").status("200");
    }

    public ResponseVOBuilder<T> fail() {
        return new ResponseVOBuilder<T>().result("Failed").status("500");
    }

    public ResponseVOBuilder<T> error(ResponseErrorVO error) {
        responseVO.setError(error);
        responseVO.setResult("Failed");
        responseVO.setStatus("500");
        return this;
    }

    public ResponseVOBuilder<T> addData(final T body) {
        responseVO.setData(body);
        responseVO.setResult("Succeeded");
        responseVO.setStatus("200");
        return this;
    }

    public ResponseVO<T> build() {
        return responseVO;
    }
}
