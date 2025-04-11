package com.rentoome.auth.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolePrivilege implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleId;

    private Long privilegeId;
}
