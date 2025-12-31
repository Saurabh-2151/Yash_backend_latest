package com.company.attendance.repository;

import com.company.attendance.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(String name);
    List<Permission> findByModule(String module);
    List<Permission> findByIsActive(Boolean isActive);
    boolean existsByName(String name);
}
