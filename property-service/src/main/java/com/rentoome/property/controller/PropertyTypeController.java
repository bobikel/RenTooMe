/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.controller;

import com.rentoome.property.domain.PropertyType;
import com.rentoome.property.domain.dto.PropertyTypeDto;
import com.rentoome.property.domain.mapper.MapStructMapper;
import com.rentoome.property.service.PropertyTypeService;
import com.rentoome.property.utils.CustomResponseHandler;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DYNABOOK
 */
@RestController
@RequestMapping("/api/v1/property-service/tproperties")
public class PropertyTypeController {

    @Autowired
    private PropertyTypeService service;

    private MapStructMapper mapstructMapper;

    public PropertyTypeController(MapStructMapper mapstructMapper, PropertyTypeService service) {
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
    public ResponseEntity<?> add(@Valid @RequestBody PropertyTypeDto propertyDto) {
        try {
            System.out.println("ici l'enregistrement : " + mapstructMapper.propertyTypeDtoTopropertyType(propertyDto));
            return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.add(mapstructMapper.propertyTypeDtoTopropertyType(propertyDto)));
        } catch (Exception e) {
            return CustomResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PostMapping("/addlist")
    public ResponseEntity<?> addMultiple(@Valid @RequestBody List<PropertyTypeDto> propertyTypeDtos) {
        try {
            if (!propertyTypeDtos.isEmpty()) {
                return CustomResponseHandler.generateResponse("Successfully saved the list!", HttpStatus.CREATED, service.addAll(mapstructMapper.propertyTypesDtoTopropertyTypes(propertyTypeDtos)));
            } else {
                return CustomResponseHandler.generateResponse("Error!!!", HttpStatus.NO_CONTENT, null);
            }
        } catch (Exception e) {
            return CustomResponseHandler.generateResponse(e.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody PropertyTypeDto propertyDto, @PathVariable Long id) {
        Optional<PropertyType> property = service.findById(id);
        if (!property.isPresent()) {
            return CustomResponseHandler.generateResponse("entity not found", HttpStatus.NOT_FOUND, null);
        } else {
            return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.edit(mapstructMapper.propertyTypeDtoTopropertyType(propertyDto)));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<PropertyType> property = service.findById(id);
        if (!property.isPresent()) {
            return CustomResponseHandler.generateResponse("entity not found", HttpStatus.NOT_FOUND, null);
        } else {
            service.delete(id);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getProperties(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

//        Page<PropertyType> pageRquest = service.getAllPageable(page, size);
        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Page-Number", String.valueOf(pageRquest.getNumber()));
//        headers.add("X-Page-Size", String.valueOf(pageRquest.getSize()));

//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(pageRquest);
//        return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.edit(mapstructMapper.propertyDtoToproperty(propertyDto)));
        return CustomResponseHandler.generateResponse("Successfully retrieve data!", HttpStatus.OK, headers, service.getAllPageable());

    }

}
