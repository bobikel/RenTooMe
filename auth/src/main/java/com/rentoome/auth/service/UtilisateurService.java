package com.rentoome.auth.service;

import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.repository.RoleRepository;
import com.rentoome.auth.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository repository;

    @Autowired
    RoleRepository rRepository;

    public UtilisateurService(UtilisateurRepository repository, RoleRepository rRepository) {
        this.repository = repository;
        this.rRepository = rRepository;
    }

    public Utilisateur add(Utilisateur entity) {
        return repository.save(entity);
    }

    public Utilisateur update(Utilisateur entity) {
        return repository.save(entity);
    }

    public Utilisateur findById(Long entity) {
        return repository.findById(entity).get();
    }

    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    public Optional<Utilisateur> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public boolean existsByEmail(String username) {
        return repository.existsByEmail(username);
    }

    public Page<Utilisateur> findAll(Pageable utilisateurs) {
        return repository.findAll(utilisateurs);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
