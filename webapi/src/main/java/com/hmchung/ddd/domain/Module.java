package com.hmchung.ddd.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hmchung.ddd.domain.audit.AbstractAuditableEntity;
import com.hmchung.ddd.domain.enumeration.ModuleType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "module")
@Data
@NoArgsConstructor
public class Module extends AbstractAuditableEntity<Long, Long> implements Serializable {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "page_name", nullable = false)
    private String pageName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ModuleType type;

    @OneToMany(mappedBy = "module")
    private Set<SubModule> subModules = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "module_modulerole",
            joinColumns = {@JoinColumn(name = "module_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "modulerole_name", referencedColumnName = "name")})
    private Set<ModuleRole> roles = new HashSet<>();
}
