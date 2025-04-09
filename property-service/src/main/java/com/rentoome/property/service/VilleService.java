/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.property.service;

import com.rentoome.property.domain.Ville;
import com.rentoome.property.repository.VilleRepository;
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
public class VilleService implements AbstractCRUDService<Ville, Long> {

    @Autowired
    private VilleRepository repository;

    @Override
    public Ville add(Ville entity) {
        return repository.save(entity);
    }

    @Override
    public Ville edit(Ville entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<Ville> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Ville> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Ville> addAll(List<Ville> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public Page<Ville> getAllPageable() {
//    public Page<Ville> getAllPageable() {

//        Pageable pageRequest = createPageRequestUsing(page, size);
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Page<Ville> allVilles = repository.findAll(Pageable.unpaged(sort));
//        int start = (int) pageRequest.getOffset();
//        int end = Math.min((start + pageRequest.getPageSize()), allVilles);

//        List<Ville> pageContent = allVilles.subList(start, end);
        return allVilles;
    }

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }
}
