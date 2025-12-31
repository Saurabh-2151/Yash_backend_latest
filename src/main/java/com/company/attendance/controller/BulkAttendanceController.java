package com.company.attendance.controller;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.mapper.AttendanceMapper;
import com.company.attendance.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendance/bulk")
@RequiredArgsConstructor
public class BulkAttendanceController {

    private final AttendanceService attendanceService;
    private final AttendanceMapper attendanceMapper;

    @PostMapping
    public ResponseEntity<List<AttendanceDto>> bulkAddAttendance(@RequestBody List<AttendanceDto> dtos) {
        var entities = dtos.stream().map(attendanceMapper::toEntity).collect(Collectors.toList());
        var result = attendanceService.bulkSave(entities);
        var response = result.stream().map(attendanceMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
