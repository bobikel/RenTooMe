/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.domain;

import com.rentoome.property.domain.enums.OccupationStatut;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author DYNABOOK
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String libelle;

    private String description;

    private String adresse;

    @Enumerated(EnumType.STRING)
    @NonNull
    private OccupationStatut occupationStatut;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = PropertyType.class, cascade = CascadeType.ALL)
    @NonNull
    private PropertyType propertyType;

}
