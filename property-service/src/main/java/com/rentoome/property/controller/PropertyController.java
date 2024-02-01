/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.controller;

import com.rentoome.property.domain.Property;
import com.rentoome.property.service.PropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DYNABOOK
 */
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    public PropertyController(PropertyService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> rettrieveAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public Property add(Property p) {
//        return service.findAll();
//    }
}
