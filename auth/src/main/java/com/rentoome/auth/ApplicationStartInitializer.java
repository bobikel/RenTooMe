/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth;

import com.rentoome.auth.domain.Privilege;
import com.rentoome.auth.domain.Role;
import com.rentoome.auth.service.PrivilegeService;
import com.rentoome.auth.service.RoleService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author manbi
 */
@Component
public class ApplicationStartInitializer implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    public ApplicationStartInitializer(RoleService roleService, PrivilegeService privilegeService) {
        this.roleService = roleService;
        this.privilegeService = privilegeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (privilegeService.findAll().isEmpty()) {
            Privilege p = new Privilege();
            p.setName("afficher la liste des locations");
            p.setDescription("afficher la liste des locations");
            privilegeService.add(p);
        }

        if (roleService.findAll().isEmpty()) {
            Role r = new Role();
            r.setName("user");
            r.setCode("user");
            r.setDescription("Role de base pour les utilisateurs qui s'inscrivent à la plate-forme");
            Set<Privilege> privileges = new HashSet<>();
            privileges.add(privilegeService.findAll().getFirst());
            r.setPrivileges(privileges);
            roleService.add(r);
        }
    }

}
