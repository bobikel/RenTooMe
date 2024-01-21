package com.rentoome.auth.controller;

import com.rentoome.auth.domain.Utilisateur;
import com.rentoome.auth.domain.dto.UtilisateurDto;
import com.rentoome.auth.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping(path = "/")
    public List<Utilisateur> getAll() {
        return utilisateurService.findAll();
    }

    @GetMapping(path = "/hello")
    public String hello(){
        return "mouf";
    }

}
