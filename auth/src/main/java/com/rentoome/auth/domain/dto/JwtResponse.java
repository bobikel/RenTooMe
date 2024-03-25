/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author manbi
 */
@Getter
@Setter
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

}