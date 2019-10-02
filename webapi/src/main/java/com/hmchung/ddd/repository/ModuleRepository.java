package com.hmchung.ddd.repository;

import com.hmchung.ddd.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {

}
