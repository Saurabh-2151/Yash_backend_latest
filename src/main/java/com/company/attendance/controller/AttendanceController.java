package com.company.attendance.controller;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import com.company.attendance.mapper.AttendanceMapper;
import com.company.attendance.service.AttendanceService;
import com.company.attendance.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Attendance REST endpoints
 */
@RestController
@RequestMapping("/api/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;
    private final AttendanceMapper attendanceMapper;
    private final EmployeeService employeeService;

    @PostMapping("/punch-in")
    public ResponseEntity<AttendanceDto> punchIn(@Valid @RequestBody AttendanceDto dto) {
        Attendance attendance = attendanceMapper.toEntity(dto);
        attendance.setEmployee(employeeService.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found")));
        Attendance saved = attendanceService.save(attendance);
        return ResponseEntity.ok(attendanceMapper.toDto(saved));
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<AttendanceDto>> listAttendance(@PathVariable("employeeId") Long employeeId,
                                                   @RequestParam LocalDate from,
                                                   @RequestParam LocalDate to) {
        List<Attendance> list = attendanceService.findAttendanceOfEmployee(employeeId, from, to);
        List<AttendanceDto> dtos = list.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
