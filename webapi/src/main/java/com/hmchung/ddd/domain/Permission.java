package com.hmchung.ddd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "permission")
@Data
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @ManyToOne
    @JsonIgnoreProperties("permissions")
    private SubModule submodule;

    @OneToMany(mappedBy = "permission")
    private Set<PermissionAction> actions = new HashSet<>();

    public Permission() {
    }

}
