package com.company.attendance.repository;

import com.company.attendance.entity.EmployeeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EmployeeTrackingRepository extends JpaRepository<EmployeeTracking, Long> {

    // List<EmployeeTracking> findByEmployeeIdOrderByTimestampDesc(Long employeeId);

    // List<EmployeeTracking> findByEmployeeIdAndTimestampBetweenOrderByTimestampDesc(
    //         Long employeeId, LocalDateTime start, LocalDateTime end);

    @Query("SELECT et FROM EmployeeTracking et WHERE et.timestamp >= :start ORDER BY et.timestamp DESC")
    List<EmployeeTracking> findRecentTracking(@Param("start") LocalDateTime start);

    @Query("SELECT et FROM EmployeeTracking et WHERE et.employee.id = :employeeId AND et.timestamp >= :start ORDER BY et.timestamp DESC")
    List<EmployeeTracking> findRecentTrackingByEmployee(@Param("employeeId") Long employeeId, @Param("start") LocalDateTime start);

    @Query("SELECT et FROM EmployeeTracking et WHERE et.latitude BETWEEN :latMin AND :latMax AND et.longitude BETWEEN :lonMin AND :lonMax")
    List<EmployeeTracking> findTrackingInArea(@Param("latMin") Double latMin, @Param("latMax") Double latMax, 
                                            @Param("lonMin") Double lonMin, @Param("lonMax") Double lonMax);

    @Query("SELECT et FROM EmployeeTracking et WHERE et.trackingType = :trackingType AND et.timestamp >= :start")
    List<EmployeeTracking> findByTrackingTypeAndTimestampAfter(@Param("trackingType") String trackingType, @Param("start") LocalDateTime start);
}
