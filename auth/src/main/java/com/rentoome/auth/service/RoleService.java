package com.rentoome.auth.service;

import com.rentoome.auth.domain.Role;
import com.rentoome.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class RoleService {

    @Autowired
    RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public Role add(Role entity) {
        return repository.save(entity);
    }

    public Role update(Role entity) {
        return repository.save(entity);
    }

    public Role findById(Long entity) {
        return repository.findById(entity).get();
    }

    public List<Role> findAll() {
        return repository.findAll();
    }

    public Optional<Role> findByName(String name) {
        return repository.findByName(name);
    }

    public Page<Role> findAll(Pageable utilisateurs) {
        return repository.findAll(utilisateurs);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
