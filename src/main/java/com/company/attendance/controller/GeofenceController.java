// package com.company.attendance.controller;

// import com.company.attendance.dto.GeofenceZoneDto;
// import com.company.attendance.entity.GeofenceZone;
// import com.company.attendance.service.GeofenceZoneService;
// import jakarta.validation.Valid;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/api/geofence")
// @RequiredArgsConstructor
// @CrossOrigin(origins = "*")
// public class GeofenceController {
//     // private final GeofenceZoneService geofenceService;

//     // @PostMapping
//     // public ResponseEntity<GeofenceZoneDto> createGeofence(@Valid @RequestBody GeofenceZoneDto dto) {
//     //     GeofenceZone geofence = geofenceService.save(dto);
//     //     return ResponseEntity.ok(geofenceService.toDto(geofence));
//     // }

//     // @GetMapping("/organization/{organizationId}")
//     // public ResponseEntity<List<GeofenceZoneDto>> getGeofencesByOrganization(@PathVariable Long organizationId) {
//     //     List<GeofenceZone> geofences = geofenceService.findByOrganizationId(organizationId);
//     //     List<GeofenceZoneDto> dtos = geofences.stream()
//     //             .map(geofenceService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/check-location")
//     // public ResponseEntity<List<GeofenceZoneDto>> checkLocationInGeofence(
//     //         @RequestParam Double latitude, @RequestParam Double longitude) {
//     //     List<GeofenceZone> geofences = geofenceService.findGeofencesContainingLocation(latitude, longitude);
//     //     List<GeofenceZoneDto> dtos = geofences.stream()
//     //             .map(geofenceService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @GetMapping("/active/{organizationId}")
//     // public ResponseEntity<List<GeofenceZoneDto>> getActiveGeofences(@PathVariable Long organizationId) {
//     //     List<GeofenceZone> geofences = geofenceService.findActiveByOrganizationId(organizationId);
//     //     List<GeofenceZoneDto> dtos = geofences.stream()
//     //             .map(geofenceService::toDto)
//     //             .collect(Collectors.toList());
//     //     return ResponseEntity.ok(dtos);
//     // }

//     // @PutMapping("/{id}")
//     // public ResponseEntity<GeofenceZoneDto> updateGeofence(@PathVariable Long id, @Valid @RequestBody GeofenceZoneDto dto) {
//     //     GeofenceZone updated = geofenceService.update(id, dto);
//     //     return ResponseEntity.ok(geofenceService.toDto(updated));
//     // }

//     // @DeleteMapping("/{id}")
//     // public ResponseEntity<Void> deleteGeofence(@PathVariable Long id) {
//     //     geofenceService.delete(id);
//     //     return ResponseEntity.noContent().build();
//     // }
// }
