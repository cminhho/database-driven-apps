package main.java.com.hmchung.ddd.repository;

import main.java.com.hmchung.ddd.domain.MultiValuedField;
import org.springframework.data.repository.CrudRepository;

public interface MultiValuedFieldRepository extends CrudRepository<MultiValuedField, Long>{

	Iterable<MultiValuedField> findByParentFieldId(Long parentFieldId);

}
