package com.rentoome.auth.service;

import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.repository.UtilisateurRepository;
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
public class UtilisateurService {

    @Autowired
    UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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

    public Page<Utilisateur> findAll(Pageable utilisateurs) {
        return repository.findAll(utilisateurs);
    }

    public Optional<Utilisateur> loadByUsername(String username) {
        Optional<Utilisateur> user = repository.findByUsername(username);
        if (user.isPresent()) {
            return user;
        }
        return Optional.empty();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<Utilisateur> user = repository.findByUsername(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("user not found with this username");
//        }
//        
//      
//    }
//
//    @Override
//    public UserDetails updatePassword(UserDetails user, String newPassword) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
