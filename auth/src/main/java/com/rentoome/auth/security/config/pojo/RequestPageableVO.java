/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.security.config.pojo;

import org.apache.commons.lang.math.NumberUtils;

/**
 *
 * @author DYNABOOK
 */
public class RequestPageableVO {
    public RequestPageableVO() {
    }
    public RequestPageableVO(Integer page, Integer rpp) {
        this.page = page;
        this.rpp = rpp;
    }
    public static final Integer DEFAULT_PAGE = NumberUtils.INTEGER_ONE;
    public static final Integer DEFAULT_RPP = Integer.valueOf(10);
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getRpp() {
        return rpp;
    }
    public void setRpp(Integer rpp) {
        this.rpp = rpp;
    }
    private Integer page = DEFAULT_PAGE;
    private Integer rpp = DEFAULT_RPP;
    public int getOffset() {
        return (getPage() - 1) * getRpp();
    }
    public final int getNumberOfRows() {
        return getRpp();
    }
}
