package com.hmchung.ddd.domain.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "lastModifiedDate"},
        allowGetters = true
)
public abstract class AbstractDateAuditableEntity<ID> extends AbstractPersistableEntity<ID> implements Serializable {

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    protected Instant createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date", nullable = false)
    protected Instant lastModifiedDate;

}