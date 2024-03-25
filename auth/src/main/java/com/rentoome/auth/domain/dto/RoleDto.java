package com.rentoome.auth.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {

    private String name;
    private String description;
    private List<Long> privilegesId;
    private String code;
}
