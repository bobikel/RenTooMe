/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentoome.property.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;

/**
 *
 * @author DYNABOOK
 * @param <T>
 * @param <ID>
 */
public abstract interface AbstractCRUDService<T extends Object, ID> {

    public T add(T entity);

    public T edit(T entity);

    public void delete(ID id);

    public List<T> findAll();

    public Optional<T> findById(Long id);

    public List<T> addAll(List<T> entities);

    public Page<T> getAllPageable();
}
