package com.company.attendance.controller;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.dto.EmployeeTrackingDto;
// import com.company.attendance.entity.EmployeeTracking;
// import com.company.attendance.service.EmployeeTrackingService;
// import jakarta.validation.Valid;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.handler.annotation.SendTo;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.web.bind.annotation.*;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/api/tracking")
// @RequiredArgsConstructor
// @CrossOrigin(origins = "*")
// public class EmployeeTrackingController {
//     // private final EmployeeTrackingService trackingService;
//     // private final SimpMessagingTemplate messagingTemplate;

//     // @PostMapping("/location")
//     // public ResponseEntity<EmployeeTrackingDto> updateLocation(@Valid @RequestBody EmployeeTrackingDto dto) {
//     //     EmployeeTracking tracking = trackingService.saveTracking(dto);
//     //     EmployeeTrackingDto response = trackingService.toDto(tracking);
        
//     //     // Send real-time update via WebSocket
//     //     messagingTemplate.convertAndSend("/topic/tracking", response);
        
//     //     return ResponseEntity.ok(response);
//     // }

//     // @GetMapping("/employee/{employeeId}")
//     // public ResponseEntity<List<EmployeeTrackingDto>> getEmployeeTracking(@PathVariable Long employeeId) {
//     //     List<EmployeeTracking> tracking = trackingService.findByEmployeeId(employeeId);
//     //     List<EmployeeTrackingDto> dtos = tracking.stream()
//     //             .map(trackingService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/employee/{employeeId}/recent")
//     // public ResponseEntity<List<EmployeeTrackingDto>> getRecentEmployeeTracking(@PathVariable Long employeeId) {
//     //     List<EmployeeTracking> tracking = trackingService.findRecentByEmployeeId(employeeId, LocalDateTime.now().minusHours(24));
//     //     List<EmployeeTrackingDto> dtos = tracking.stream()
//     //             .map(trackingService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/area")
//     // public ResponseEntity<List<EmployeeTrackingDto>> getTrackingInArea(
//     //         @RequestParam Double latMin, @RequestParam Double latMax,
//     //         @RequestParam Double lonMin, @RequestParam Double lonMax) {
//     //     List<EmployeeTracking> tracking = trackingService.findTrackingInArea(latMin, latMax, lonMin, lonMax);
//     //     List<EmployeeTrackingDto> dtos = tracking.stream()
//     //             .map(trackingService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/recent")
//     // public ResponseEntity<List<EmployeeTrackingDto>> getRecentTracking() {
//     //     List<EmployeeTracking> tracking = trackingService.findRecentTracking(LocalDateTime.now().minusHours(1));
//     //     List<EmployeeTrackingDto> dtos = tracking.stream()
//     //             .map(trackingService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/type/{trackingType}")
//     // public ResponseEntity<List<EmployeeTrackingDto>> getTrackingByType(@PathVariable String trackingType) {
//     //     List<EmployeeTracking> tracking = trackingService.findByTrackingType(trackingType);
//     //     List<EmployeeTrackingDto> dtos = tracking.stream()
//     //             .map(trackingService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // // WebSocket endpoint for real-time tracking updates
//     // @MessageMapping("/tracking/update")
//     // @SendTo("/topic/tracking")
//     // public EmployeeTrackingDto handleTrackingUpdate(EmployeeTrackingDto trackingDto) {
//     //     EmployeeTracking tracking = trackingService.saveTracking(trackingDto);
//     //     return trackingService.toDto(tracking);
//     // }
// }
