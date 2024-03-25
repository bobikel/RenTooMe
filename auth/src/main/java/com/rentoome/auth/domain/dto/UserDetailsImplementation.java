/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.domain.dto;

import com.rentoome.auth.domain.Privilege;
import com.rentoome.auth.domain.Role;
import com.rentoome.auth.domain.Utilisateur;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author manbi
 */
public class UserDetailsImplementation implements UserDetails {

    private final Utilisateur utilisateur;

    public UserDetailsImplementation(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        Set<Role> roles = utilisateur.getRoles();

        for (Role role : roles) {
            // Ajouter le rôle lui-même en tant qu'autorité
            authorities.add(new SimpleGrantedAuthority(role.getName()));

            // Ajouter les privilèges du rôle en tant qu'autorités
            Set<Privilege> privileges = role.getPrivileges();
            for (Privilege privilege : privileges) {
                authorities.add(new SimpleGrantedAuthority(privilege.getName()));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return utilisateur.getPassword();
    }

    public String getEmail() {
        return utilisateur.getEmail();
    }

    public Long getId() {
        return utilisateur.getId();
    }

    @Override
    public String getUsername() {
        return utilisateur.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !utilisateur.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !utilisateur.isAccountexpired();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  
    }

    @Override
    public boolean isEnabled() {
        return true;  
    }

}
