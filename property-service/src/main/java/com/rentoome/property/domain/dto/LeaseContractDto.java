/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DYNABOOK
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaseContractDto {

    private Long id;

//    @NotNull
//    @NotBlank
//    private PropertyDto property;

    @NotNull
    @NotBlank
    private Long propertyId;

    @NotNull
    private Long userId;

    private LocalDate startRentDate;

    private LocalDate rentDuration;

    private String leaseStatut;
}
