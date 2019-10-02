package com.hmchung.ddd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hmchung.ddd.domain.audit.AbstractAuditableEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "submodule")
@Data
@NoArgsConstructor
public class SubModule extends AbstractAuditableEntity<Long, Long> implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnoreProperties("module")
    private Module module;

//    @OneToMany(mappedBy = "submodule")
//    private Set<FormField> fields = new HashSet<>();

    @OneToMany(mappedBy = "submodule")
    private Set<Permission> permissions = new HashSet<>();

}
