/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.Pays;
import com.rentoome.property.repository.PaysRepository;
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
public class PaysService implements AbstractCRUDService<Pays, Long> {

    @Autowired
    private PaysRepository repository;

    @Override
    public Pays add(Pays entity) {
        return repository.save(entity);
    }

    @Override
    public Pays edit(Pays entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<Pays> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pays> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Pays> addAll(List<Pays> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Page<Pays> getAllPageable() {
//    public Page<Pays> getAllPageable() {

//        Pageable pageRequest = createPageRequestUsing(page, size);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<Pays> allPayss = repository.findAll(Pageable.unpaged(sort));
//        int start = (int) pageRequest.getOffset();
//        int end = Math.min((start + pageRequest.getPageSize()), allPayss);

//        List<Pays> pageContent = allPayss.subList(start, end);
        return allPayss;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
