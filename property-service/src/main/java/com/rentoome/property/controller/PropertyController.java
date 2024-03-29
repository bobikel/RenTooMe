/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.controller;

import com.rentoome.property.domain.Property;
import com.rentoome.property.domain.dto.PropertyDto;
import com.rentoome.property.domain.mapper.MapStructMapper;
import com.rentoome.property.service.PropertyService;
import com.rentoome.property.utils.CustomResponseHandler;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private MapStructMapper mapstructMapper;

    public PropertyController(MapStructMapper mapstructMapper, PropertyService service) {
        this.mapstructMapper = mapstructMapper;
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> rettrieveAll() {
        try {
            return CustomResponseHandler.generateResponse("Successfully retrieve data!", HttpStatus.OK, service.findAll());

        } catch (Exception e) {
            return CustomResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody PropertyDto propertyDto) {
        try {
            return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.add(mapstructMapper.propertyDtoToproperty(propertyDto)));

        } catch (Exception e) {
            return CustomResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PostMapping("/addlist")
    public ResponseEntity<?> addMultiple(@Valid @RequestBody List<PropertyDto> propertyDtos) throws IOException {
        try {
            if (!propertyDtos.isEmpty()) {
                return CustomResponseHandler.generateResponse("Successfully saved the list!", HttpStatus.CREATED, service.addAll(mapstructMapper.propertiesDtoToproperties(propertyDtos)));
            } else {
                return CustomResponseHandler.generateResponse("Error!!!", HttpStatus.NO_CONTENT, null);
            }
        } catch (Exception e) {
            return CustomResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody PropertyDto propertyDto, @PathVariable Long id) {
        Optional<Property> property = service.findById(id);
        if (!property.isPresent()) {
            return CustomResponseHandler.generateResponse("entity not found", HttpStatus.NOT_FOUND, null);
        } else {
            return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.edit(mapstructMapper.propertyDtoToproperty(propertyDto)));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Property> property = service.findById(id);
        if (!property.isPresent()) {
            return CustomResponseHandler.generateResponse("entity not found", HttpStatus.NOT_FOUND, null);
        } else {
            service.delete(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }
    }

}
