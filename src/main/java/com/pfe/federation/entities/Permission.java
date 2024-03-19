package com.pfe.federation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();

    public Permission(String name,String description) {
        this.name = name;
        this.description=description;
    }
}
