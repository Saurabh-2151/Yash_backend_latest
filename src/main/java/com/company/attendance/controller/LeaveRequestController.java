package com.company.attendance.controller;
import com.company.attendance.dto.LeaveRequestDto;
import com.company.attendance.entity.LeaveRequest;
import com.company.attendance.mapper.LeaveRequestMapper;
import com.company.attendance.service.LeaveRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
public class LeaveRequestController {
    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;
    @GetMapping
    public ResponseEntity<List<LeaveRequestDto>> listLeaves() {
        var leaves = leaveRequestService.findAll();
        var dtos = leaves.stream().map(leaveRequestMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestDto> getLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveRequestMapper.toDto(leaveRequestService.getById(id)));
    }
    @PostMapping
    public ResponseEntity<LeaveRequestDto> createLeave(@Valid @RequestBody LeaveRequestDto dto) {
        LeaveRequest leave = leaveRequestService.save(leaveRequestMapper.toEntity(dto));
        return ResponseEntity.ok(leaveRequestMapper.toDto(leave));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequestDto> updateLeave(@PathVariable Long id, @RequestBody LeaveRequestDto dto) {
        LeaveRequest leave = leaveRequestService.getById(id);
        LeaveRequest saved = leaveRequestService.save(leaveRequestMapper.toEntity(dto));
        return ResponseEntity.ok(leaveRequestMapper.toDto(saved));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveRequestService.delete(id);
        return ResponseEntity.ok().build();
    }
}

