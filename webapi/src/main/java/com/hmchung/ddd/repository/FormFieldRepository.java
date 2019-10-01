package com.hmchung.ddd.repository;

import com.hmchung.ddd.domain.FormField;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {

}
