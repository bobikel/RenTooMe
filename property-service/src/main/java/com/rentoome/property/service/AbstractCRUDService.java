/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.rentoome.property.service;

import com.netflix.discovery.converters.Auto;
import com.rentoome.property.domain.Property;
import java.util.List;
import java.util.Optional;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

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

    public List<Property> addCity(List<Property> entities);
}
