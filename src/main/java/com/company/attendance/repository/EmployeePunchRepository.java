package com.company.attendance.repository;

import com.company.attendance.entity.EmployeePunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePunchRepository extends JpaRepository<EmployeePunch, Long> {

    // List<EmployeePunch> findByEmployeeIdOrderByPunchTimeDesc(Long employeeId);

    // List<EmployeePunch> findByEmployeeIdAndPunchTimeBetweenOrderByPunchTimeDesc(
    //         Long employeeId, LocalDateTime start, LocalDateTime end);

    // Optional<EmployeePunch> findFirstByEmployeeIdAndPunchTypeOrderByPunchTimeDesc(Long employeeId, String punchType);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.employee.id = :employeeId AND DATE(ep.punchTime) = :date ORDER BY ep.punchTime ASC")
    List<EmployeePunch> findByEmployeeIdAndDate(@Param("employeeId") Long employeeId, @Param("date") LocalDate date);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.punchTime >= :start ORDER BY ep.punchTime DESC")
    List<EmployeePunch> findRecentPunches(@Param("start") LocalDateTime start);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.employee.id = :employeeId AND ep.punchTime >= :start ORDER BY ep.punchTime DESC")
    List<EmployeePunch> findRecentPunchesByEmployee(@Param("employeeId") Long employeeId, @Param("start") LocalDateTime start);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.latitude BETWEEN :latMin AND :latMax AND ep.longitude BETWEEN :lonMin AND :lonMax")
    List<EmployeePunch> findPunchesInArea(@Param("latMin") Double latMin, @Param("latMax") Double latMax, 
                                         @Param("lonMin") Double lonMin, @Param("lonMax") Double lonMax);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.punchType = :punchType AND ep.punchTime >= :start")
    List<EmployeePunch> findByPunchTypeAndTimestampAfter(@Param("punchType") String punchType, @Param("start") LocalDateTime start);

    @Query("SELECT ep FROM EmployeePunch ep WHERE ep.isWithinGeofence = false AND ep.punchTime >= :start")
    List<EmployeePunch> findPunchesOutsideGeofence(@Param("start") LocalDateTime start);
}
