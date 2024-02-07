/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.PropertyImage;
import com.rentoome.property.repository.PropertyImageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DYNABOOK
 */
@Service
public class PropertyImageService implements AbstractCRUDService<PropertyImage, Long> {

    @Autowired
    private PropertyImageRepository repository;

    @Override
    public PropertyImage add(PropertyImage entity) {
        return repository.save(entity);
    }

    @Override
    public PropertyImage edit(PropertyImage entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<PropertyImage> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PropertyImage> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PropertyImage> addAll(List<PropertyImage> entities) {
        return repository.saveAll(entities);
    }
}
