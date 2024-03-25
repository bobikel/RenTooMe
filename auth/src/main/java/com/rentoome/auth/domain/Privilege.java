package com.rentoome.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Table
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "nom requis")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "privileges", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Role> roles;
}
