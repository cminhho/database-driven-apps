package com.hmchung.ddd.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "permission_action")
@Data
public class PermissionAction implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long fieldId;

    @Size(max = 100)
    @Column(length = 100)
    private String name;

    @ManyToOne
    @JsonIgnoreProperties("actions")
    private Permission permission;

    public PermissionAction() {
    }

}
