/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.Quartier;
import com.rentoome.property.repository.QuartierRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author DYNABOOK
 */
@Service
public class QuartierService implements AbstractCRUDService<Quartier, Long> {

    @Autowired
    private QuartierRepository repository;

    @Override
    public Quartier add(Quartier entity) {
        return repository.save(entity);
    }

    @Override
    public Quartier edit(Quartier entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<Quartier> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Quartier> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Quartier> addAll(List<Quartier> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Page<Quartier> getAllPageable() {
//    public Page<Quartier> getAllPageable() {

//        Pageable pageRequest = createPageRequestUsing(page, size);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<Quartier> allQuartiers = repository.findAll(Pageable.unpaged(sort));
//        int start = (int) pageRequest.getOffset();
//        int end = Math.min((start + pageRequest.getPageSize()), allQuartiers);

//        List<Quartier> pageContent = allQuartiers.subList(start, end);
        return allQuartiers;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
