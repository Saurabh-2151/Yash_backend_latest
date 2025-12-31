package com.company.attendance.repository;

import com.company.attendance.entity.GeofenceZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeofenceZoneRepository extends JpaRepository<GeofenceZone, Long> {
    List<GeofenceZone> findByIsActive(Boolean isActive);
}
