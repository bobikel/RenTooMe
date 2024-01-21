package com.rentoome.auth.domain;

import com.google.common.base.Objects;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Utilisateur extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "nom requis")
    private String name;

    @NotNull(message = "username requis")
    private String username;

    @NotNull(message = "email requis")
    private String email;

    private String password;

    private String sex;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "UTILISATEUR_ROLE",
            joinColumns =
            @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "ID"),
            inverseJoinColumns =
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
    )
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equal(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
