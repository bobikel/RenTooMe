package com.rentoome.auth.service;

import com.rentoome.auth.domain.Privilege;
import com.rentoome.auth.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class PrivilegeService {

    @Autowired
    PrivilegeRepository repository;

    public PrivilegeService(PrivilegeRepository repository) {
        this.repository = repository;
    }

    public Privilege add(Privilege entity) {
        return repository.save(entity);
    }

    public Privilege update(Privilege entity) {
        return repository.save(entity);
    }

    public Privilege findById(Long entity) {
        return repository.findById(entity).get();
    }

    public List<Privilege> findAll() {
        return repository.findAll();
    }


    public Page<Privilege> findAll(Pageable utilisateurs) {
        return repository.findAll(utilisateurs);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
