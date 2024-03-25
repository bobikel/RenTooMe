/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.Property;
import com.rentoome.property.domain.PropertyType;
import com.rentoome.property.repository.PropertyTypeRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

//    @Override
    @Override
    public Page<PropertyType> getAllPageable() {

//        Pageable pageRequest = createPageRequestUsing(page, size);

//        return new PageImpl<>(repository.findAll());
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<PropertyType> allPropertys = repository.findAll(Pageable.unpaged(sort));
//        int start = (int) pageRequest.getOffset();
//        int end = Math.min((start + pageRequest.getPageSize()), allPropertys.size());

//        List<Property> pageContent = allPropertys.subList(start, end);
        return allPropertys;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

}
