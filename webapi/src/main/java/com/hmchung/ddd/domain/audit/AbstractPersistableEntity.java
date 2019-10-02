package com.hmchung.ddd.domain.audit;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractPersistableEntity<ID> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected ID id;

    @Version
    protected Long version;
}