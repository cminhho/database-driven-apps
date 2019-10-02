package com.hmchung.ddd.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity(name = "modulerole")
public class ModuleRole implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long fieldId;

    @NotNull
    @Size(max = 100)
    @Column(length = 100)
    private String name;

    public ModuleRole() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ModuleRole{" +
                "name='" + name + '\'' +
                '}';
    }
}
