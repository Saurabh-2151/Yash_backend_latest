package com.company.attendance.repository;

import com.company.attendance.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {
    // List<Designation> findByOrganizationId(Long organizationId);
    List<Designation> findByIsActive(Boolean isActive);
    Optional<Designation> findByCode(String code);
    boolean existsByCode(String code);
}
