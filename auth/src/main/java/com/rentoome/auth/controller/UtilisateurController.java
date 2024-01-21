package com.rentoome.auth.controller;

import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
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

    @PostMapping(path = "/signup")
    public Utilisateur register(Utilisateur user) {

        return user;
    }
}
