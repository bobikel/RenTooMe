package com.rentoome.auth.repository;

import com.rentoome.auth.domain.Utilisateur;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>, JpaSpecificationExecutor<Utilisateur> {

    Optional<Utilisateur> findByUsername(String username);

    Optional<Utilisateur> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
