package com.company.attendance.controller;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.dto.EmployeePunchDto;
// import com.company.attendance.service.EmployeePunchService;
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import jakarta.validation.Valid;
// import java.util.List;

// @RestController
// @RequestMapping("/api/employee-punches")
// @RequiredArgsConstructor
// @Slf4j
// public class EmployeePunchController {
    
//     // private final EmployeePunchService employeePunchService;

//     // @PostMapping
//     // public ResponseEntity<EmployeePunchDto> createPunch(@Valid @RequestBody EmployeePunchDto dto) {
//     //     log.info("Creating punch for employee: {}", dto.getEmployeeId());
        
//     //     EmployeePunchDto created = employeePunchService.savePunch(dto);
        
//     //     log.info("Punch created successfully with ID: {}", created.getId());
//     //     return ResponseEntity.ok(created);
//     // }

//     // @GetMapping("/employee/{employeeId}")
//     // public ResponseEntity<List<EmployeePunchDto>> getPunchesByEmployeeId(@PathVariable Long employeeId) {
//     //     log.info("Fetching punches for employee ID: {}", employeeId);
        
//     //     List<EmployeePunchDto> punches = employeePunchService.findByEmployeeId(employeeId)
//     //             .stream()
//     //             .map(employeePunchService::toDto)
//     //             .toList();
        
//     //     return ResponseEntity.ok(punches);
//     // }

//     // @GetMapping("/employee/{employeeId}/recent")
//     // public ResponseEntity<List<EmployeePunchDto>> getRecentPunchesByEmployeeId(
//     //             @PathVariable Long employeeId,
//     //             @RequestParam(required = false) String since) {
//     //     log.info("Fetching recent punches for employee ID: {}", employeeId);
        
//     //     LocalDateTime sinceDateTime = since != null ? LocalDateTime.parse(since) : LocalDateTime.now().minusDays(7);
//     //     List<EmployeePunchDto> punches = employeePunchService.findRecentByEmployeeId(employeeId, sinceDateTime)
//     //             .stream()
//     //             .map(employeePunchService::toDto)
//     //             .toList();
        
//     //     return ResponseEntity.ok(punches);
//     // }

//     // @GetMapping("/recent")
//     // public ResponseEntity<List<EmployeePunchDto>> getRecentPunches(@RequestParam(required = false) String since) {
//     //     log.info("Fetching recent punches since: {}", since);
        
//     //     LocalDateTime sinceDateTime = since != null ? LocalDateTime.parse(since) : LocalDateTime.now().minusHours(24);
//     //     List<EmployeePunchDto> punches = employeePunchService.findRecentPunches(sinceDateTime)
//     //             .stream()
//     //             .map(employeePunchService::toDto)
//     //             .toList();
        
//     //     return ResponseEntity.ok(punches);
//     // }
// }
