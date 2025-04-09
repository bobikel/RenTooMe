/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.domain.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author DYNABOOK
 */
@Getter
@Setter
public class PropertyDto {

    private Long id;

    @NonNull
    private String libelle;

    private String description;

    private String adresse;

    @NonNull
    private String occupationStatut;

    @NonNull
    private Long propertyTypeId;

//    @NonNull
//    private PropertyTypeDto propertyTypeDto;
}
