/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.Property;
import com.rentoome.property.repository.PropertyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DYNABOOK
 */
@Service
public class PropertyService implements AbstractCRUDService<Property, Long> {

    @Autowired
    private PropertyRepository repository;

    @Override
    public Property add(Property entity) {
        return repository.save(entity);
    }

    @Override
    public Property edit(Property entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<Property> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Property> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Property> addCity(List<Property> entities) {
        return repository.saveAll(entities);
    }
}
