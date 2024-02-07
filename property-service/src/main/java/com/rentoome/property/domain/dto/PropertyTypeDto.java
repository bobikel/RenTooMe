/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 * @author DYNABOOK
 */
@Getter
@Setter
public class PropertyTypeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("libelle")
    @NonNull
    @NotBlank
    private String libelle;

    @JsonProperty("description")
    private String description;

}
