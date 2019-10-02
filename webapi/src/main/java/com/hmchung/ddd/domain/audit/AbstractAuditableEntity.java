package com.hmchung.ddd.domain.audit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"createdDate", "lastModifiedDate"},
        allowGetters = true
)
public abstract class AbstractAuditableEntity<U, ID> extends AbstractDateAuditableEntity<ID> implements Serializable {
    @CreatedBy
//    @JoinColumn(name = "created_by")
    protected U createdBy;

    @LastModifiedBy
//    @JoinColumn(name = "last_modified_by")
    protected U lastModifiedBy;
}