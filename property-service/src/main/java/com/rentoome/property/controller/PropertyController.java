/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.controller;

import com.rentoome.property.domain.Property;
import com.rentoome.property.domain.dto.PropertyDto;
import com.rentoome.property.domain.enums.OccupationStatut;
import com.rentoome.property.domain.mapper.MapStructMapper;
import com.rentoome.property.service.PropertyService;
import com.rentoome.property.service.PropertyTypeService;
import com.rentoome.property.utils.CustomResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.io.IOException;
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
@RequestMapping("/api/v1/property-service/properties")
public class PropertyController {

    @Autowired
    private final PropertyService service;

    @Autowired
    private final PropertyTypeService propertyTypeService;

    private final MapStructMapper mapstructMapper;

    public PropertyController(MapStructMapper mapstructMapper, PropertyService service, PropertyTypeService propertyTypeService) {
        this.mapstructMapper = mapstructMapper;
        this.service = service;
        this.propertyTypeService = propertyTypeService;
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
        System.out.println("la valeur de l'objet : " + propertyDto.getAdresse() + propertyDto.getPropertyTypeId() + propertyDto.getLibelle());
        try {
            Property property = new Property();
            property.setLibelle(propertyDto.getLibelle());
            property.setDescription(propertyDto.getDescription());
            property.setAdresse(propertyDto.getAdresse());
            property.setOccupationStatut(OccupationStatut.valueOf(propertyDto.getOccupationStatut()));

            propertyTypeService.findById(propertyDto.getPropertyTypeId())
                    .ifPresentOrElse(
                            (pt) -> property.setPropertyType(pt),
                            () -> {
                                throw new EntityNotFoundException();
                            });

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

    @GetMapping("/all")
    public ResponseEntity<?> getProperties() {

//        Page<Property> pageRquest = service.getAllPageable(page, size);
        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Page-Number", String.valueOf(pageRquest.getNumber()));
//        headers.add("X-Page-Size", String.valueOf(pageRquest.getSize()));

//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(pageRquest);

//        return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.edit(mapstructMapper.propertyDtoToproperty(propertyDto)));
        return CustomResponseHandler.generateResponse("Successfully retrieve data!", HttpStatus.OK, service.getAllPageable());

    }

}
