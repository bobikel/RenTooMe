package com.rentoome.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    @NotNull(message = "nom requis")
    private String name;

    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Utilisateur> utilisateurs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PRIVILEGE",
            joinColumns
            = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns
            = @JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "ID")
    )
    @JsonIgnore
    private Set<Privilege> privileges;
}
