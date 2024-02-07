/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.PropertyType;
import com.rentoome.property.repository.PropertyTypeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DYNABOOK
 */
@Service
public class PropertyTypeService implements AbstractCRUDService<PropertyType, Long> {

    @Autowired
    private PropertyTypeRepository repository;

    @Override
    public PropertyType add(PropertyType entity) {
        return repository.save(entity);
    }

    @Override
    public PropertyType edit(PropertyType entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<PropertyType> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<PropertyType> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<PropertyType> addAll(List<PropertyType> entities) {
        return repository.saveAll(entities);
    }
}
