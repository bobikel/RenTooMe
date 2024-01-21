/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.security.config.pojo;

import com.rentoome.auth.domain.Role;
import com.rentoome.auth.domain.Utilisateur;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author DYNABOOK
 */
public class UserPrincipal implements UserDetails {

    private Utilisateur user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountexpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isDeleted();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

}
