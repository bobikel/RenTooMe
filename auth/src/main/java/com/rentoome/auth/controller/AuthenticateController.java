/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.controller;

import com.rentoome.auth.domain.Role;
import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.domain.dto.LoginRequest;
import com.rentoome.auth.domain.dto.UserDetailsImplementation;
import com.rentoome.auth.domain.dto.UtilisateurDto;
import com.rentoome.auth.request.response.JwtResponse;
import com.rentoome.auth.security.JwtUtil;
import com.rentoome.auth.service.RoleService;
import com.rentoome.auth.service.UtilisateurService;
import com.rentoome.auth.utils.CustomMessage;
import com.rentoome.auth.utils.CustomResponseHandler;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manbi
 */
@RestController
@RequestMapping("api/v1/auth")
public class AuthenticateController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UtilisateurService service;

    @Autowired
    private RoleService roleService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtil jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        System.out.println("on entre dans le auth avec le login ci :" + loginRequest.getPassword() + " " + loginRequest.getUsername());
        try {
            System.out.println("l'authentification");

            // Si l'authentification réussit, générer un token JWT
            UserDetails userDetails = service.loadUserByUsername(loginRequest.getUsername());
            System.out.println("user details : " + userDetails);

            // Retourner le token en réponse
            return ResponseEntity.ok("ok");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username/password");
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<?> register(UtilisateurDto dto) {

        Utilisateur user = new Utilisateur();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        if (service.existsByEmail(dto.getUsername())) {
            return CustomResponseHandler.generateResponse(CustomMessage.EMAIL_DUPLICATE_MESSAGE + " " + dto.getEmail(), HttpStatus.CONFLICT, null);
        }
        user.setUsername(dto.getUsername());

        if (service.existsByUsername(dto.getUsername())) {
            return CustomResponseHandler.generateResponse(CustomMessage.ENTITY_DUPLICATE_MESSAGE + " " + dto.getUsername(), HttpStatus.CONFLICT, null);
        }
        user.setSex(dto.getSex());
        user.setPassword(encoder.encode(dto.getPassword()));
        Set<Role> roles = new HashSet<>();
        dto.getRolesName().forEach(name -> {
            roleService.findByName(name).ifPresentOrElse(
                    (r1) -> {
                        roles.add(r1);
                    },
                    () -> {
                        throw new EntityNotFoundException("Le role n'existe pas");
                    });
        });
        user.setRoles(roles);
        return CustomResponseHandler.generateResponse("Successfully saved!", HttpStatus.CREATED, service.add(user));
    }

}
