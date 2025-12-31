package com.company.attendance.repository;

import com.company.attendance.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
    // List<Shift> findByOrganizationIdAndIsActive(Long organizationId, Boolean isActive);
    List<Shift> findByIsActive(Boolean isActive);
}
