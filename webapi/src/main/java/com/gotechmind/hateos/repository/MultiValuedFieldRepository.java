package com.gotechmind.hateos.repository;

import com.gotechmind.hateos.domain.MultiValuedField;
import org.springframework.data.repository.CrudRepository;

public interface MultiValuedFieldRepository extends CrudRepository<MultiValuedField, Long>{

	Iterable<MultiValuedField> findByParentFieldId(Long parentFieldId);

}
