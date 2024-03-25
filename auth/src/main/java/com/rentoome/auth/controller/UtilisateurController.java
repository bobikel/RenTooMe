package com.rentoome.auth.controller;

import com.rentoome.auth.domain.Role;
import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.domain.dto.UtilisateurDto;
import com.rentoome.auth.service.RoleService;
import com.rentoome.auth.service.UtilisateurService;
import com.rentoome.auth.utils.CustomMessage;
import com.rentoome.auth.utils.CustomResponseHandler;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private final UtilisateurService service;

    // a constructor so that the Spring container can inject a MovieFinder
    public UtilisateurController(UtilisateurService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public List<Utilisateur> getAll() {
        return service.findAll();
    }

}
