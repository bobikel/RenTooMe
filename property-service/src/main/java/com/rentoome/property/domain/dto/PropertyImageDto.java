/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.domain.dto;

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
public class PropertyImageDto {

    private Long id;

    private String libelle;

    private String alternativeText;

    private String legend;

    private Long propertyId;

//    private PropertyDto propertyDto;
    private String url;

}
