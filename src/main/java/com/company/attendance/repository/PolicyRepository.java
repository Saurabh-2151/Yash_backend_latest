package com.company.attendance.repository;

import com.company.attendance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    // List<Policy> findByOrganizationIdAndIsActive(Long organizationId, Boolean isActive);
    List<Policy> findByTypeAndIsActive(String type, Boolean isActive);
}
