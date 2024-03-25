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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public List<Property> addAll(List<Property> entities) {
        return repository.saveAll(entities);
    }

    @Override
//    public Page<Property> getAllPageable(int page, int size) {
    public Page<Property> getAllPageable() {

//        Pageable pageRequest = createPageRequestUsing(page, size);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<Property> allPropertys = repository.findAll(Pageable.unpaged(sort));
//        int start = (int) pageRequest.getOffset();
//        int end = Math.min((start + pageRequest.getPageSize()), allPropertys.size());

//        List<Property> pageContent = allPropertys.subList(start, end);
        return allPropertys;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
