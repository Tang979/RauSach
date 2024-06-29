package com.example.RauSach.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
