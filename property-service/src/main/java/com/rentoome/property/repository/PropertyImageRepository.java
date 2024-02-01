/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentoome.property.repository;

import com.rentoome.property.domain.PropertyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DYNABOOK
 */
@Repository
public interface PropertyImageRepository extends JpaRepository<PropertyImage, Long>, JpaSpecificationExecutor<PropertyImage> {
    
}
