package com.pfe.federation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PermissionSupplementaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "permissionSupplementaires")
    private Collection<User> users = new HashSet<>();

    public PermissionSupplementaire(String name,String description) {
        this.name = name;
        this.description=description;
    }
    public void removeAllPermissionsSupplementaires(){
        if (this.getUsers() != null){
            List<User> usersInPermission = this.getUsers().stream().toList();
            usersInPermission.forEach(this::removePermissionSupplementaire);
        }
    }
    public void assignPermissionSupplementaire(User user){
        user.getPermissionSupplementaires().add(this);
        this.getUsers().add(user);
    }
    public void removePermissionSupplementaire(User user) {
        user.getPermissionSupplementaires().remove(this);
        this.getUsers().remove(user);
    }
}
