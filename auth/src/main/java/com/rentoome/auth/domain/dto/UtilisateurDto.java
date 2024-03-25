package com.rentoome.auth.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UtilisateurDto {

    private String name;
    private String email;
    private String sex;
    private String password;
    private String username;
    private List<String> rolesName;

    }
