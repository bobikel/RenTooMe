/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.domain.dto;

import lombok.Data;

/**
 *
 * @author manbi
 */
@Data
public class FdxLoginRequest {
    
    private String codeParticipant;
    private String password;
    private int validite;
    
}
