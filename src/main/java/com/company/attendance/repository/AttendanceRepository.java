package com.company.attendance.repository;

import com.company.attendance.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeIdAndDateBetween(Long employeeId, LocalDate from, LocalDate to);
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByEmployeeId(Long employeeId);
}

