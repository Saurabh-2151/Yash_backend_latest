package com.company.attendance.service;

import com.company.attendance.entity.Attendance;
import com.company.attendance.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    // ...other services can be injected for report, summary, etc.

    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> findAttendanceOfEmployee(Long employeeId, LocalDate from, LocalDate to) {
        return attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, from, to);
    }

    public List<Attendance> findByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public List<Attendance> bulkSave(List<Attendance> attendances) {
        return attendanceRepository.saveAll(attendances);
    }

    public Map<String, Object> getDashboardSummary(LocalDate date) {
        // Example stub summary, real impl aggregates by team, present, etc.
        Map<String, Object> summary = new HashMap<>();
        var all = attendanceRepository.findByDate(date);
        summary.put("date", date);
        summary.put("totalEmployees", all.size());
        summary.put("punchedIn", all.stream().filter(a -> "PUNCHED_IN".equals(a.getStatus().toString())).count());
        // ...add more fields as needed
        return summary;
    }
}
