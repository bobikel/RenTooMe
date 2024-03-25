package com.rentoome.auth.service;

import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.domain.dto.UserDetailsImplementation;
import com.rentoome.auth.repository.RoleRepository;
import com.rentoome.auth.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UtilisateurService implements UserDetailsService {

    @Autowired
    UtilisateurRepository repository;

    @Autowired
    RoleRepository rRepository;

    public UtilisateurService(UtilisateurRepository repository, RoleRepository rRepository) {
        this.repository = repository;
        this.repository = repository;
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
//
//    public Optional<Utilisateur> loadByUsername(String username) {
//        Optional<Utilisateur> user = repository.findByUsername(username);
//        if (user.isPresent()) {
//            return user;
//        }
//        return Optional.empty();
//    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public UserDetails updatePassword(UserDetails user, String newPassword) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Charger l'utilisateur depuis la base de données en utilisant le service utilisateur
        Utilisateur utilisateur = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur : " + username + " non trouvé"));

        // Créer un UserDetailsImplementation à partir de l'utilisateur chargé
        UserDetails userDetails = new UserDetailsImplementation(utilisateur);

        return userDetails;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
