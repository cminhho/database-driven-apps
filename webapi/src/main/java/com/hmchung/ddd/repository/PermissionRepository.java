package com.hmchung.ddd.repository;

import com.hmchung.ddd.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
