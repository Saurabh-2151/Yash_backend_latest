package com.company.attendance.repository;

import com.company.attendance.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    // List<Announcement> findByOrganizationIdAndIsActive(Long organizationId, Boolean isActive);
    
    @Query("SELECT a FROM Announcement a WHERE a.organization.id = :orgId AND a.isActive = true " +
           "AND a.publishFrom <= :now AND a.publishTo >= :now ORDER BY a.isPinned DESC, a.publishFrom DESC")
    List<Announcement> findActiveAnnouncements(@Param("orgId") Long orgId, @Param("now") LocalDateTime now);
    
    @Query("SELECT a FROM Announcement a WHERE a.organization.id = :orgId AND a.isActive = true AND a.type = :type " +
           "AND a.publishFrom <= :now AND a.publishTo >= :now ORDER BY a.isPinned DESC, a.publishFrom DESC")
    List<Announcement> findActiveAnnouncementsByType(@Param("orgId") Long orgId, @Param("type") String type, @Param("now") LocalDateTime now);
}
