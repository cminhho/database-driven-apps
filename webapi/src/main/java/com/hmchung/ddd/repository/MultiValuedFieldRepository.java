package com.hmchung.ddd.repository;

import com.hmchung.ddd.domain.MultiValuedField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MultiValuedFieldRepository extends JpaRepository<MultiValuedField, Long> {

	Iterable<MultiValuedField> findByParentFieldId(Long parentFieldId);

}
