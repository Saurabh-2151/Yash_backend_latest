// package com.company.attendance.service;

// import com.company.attendance.dto.GeofenceZoneDto;
// import com.company.attendance.entity.GeofenceZone;
// import com.company.attendance.entity.Organization;
// import com.company.attendance.repository.GeofenceZoneRepository;
// import com.company.attendance.repository.OrganizationRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDateTime;
// import java.util.List;

// @Service
// @RequiredArgsConstructor
// @Transactional
// public class GeofenceZoneService {
//     // private final GeofenceZoneRepository geofenceRepository;
//     // private final OrganizationRepository organizationRepository;

//     // public GeofenceZone save(GeofenceZoneDto dto) {
//     //     Organization organization = organizationRepository.findById(dto.getOrganizationId())
//     //             .orElseThrow(() -> new RuntimeException("Organization not found"));

//     //     GeofenceZone geofence = GeofenceZone.builder()
//     //             .organization(organization)
//     //             .name(dto.getName())
//     //             .description(dto.getDescription())
//     //             .latitude(dto.getLatitude())
//     //             .longitude(dto.getLongitude())
//     //             .radius(dto.getRadius())
//     //             .fenceType(dto.getFenceType())
//     //             .isActive(dto.getIsActive() != null ? dto.getIsActive() : true)
//     //             .createdAt(LocalDateTime.now())
//     //             .createdBy(dto.getCreatedBy())
//     //             .build();

//     //     return geofenceRepository.save(geofence);
//     // }

//     // public List<GeofenceZone> findByOrganizationId(Long organizationId) {
//     //     // For now, return all active geofences since we commented out the organization-specific method
//     //     return geofenceRepository.findActiveGeofencesByOrganization(organizationId);
//     // }

//     // public List<GeofenceZone> findActiveByOrganizationId(Long organizationId) {
//     //     return geofenceRepository.findActiveGeofencesByOrganization(organizationId);
//     // }

//     // public List<GeofenceZone> findGeofencesContainingLocation(Double latitude, Double longitude) {
//     //     return geofenceRepository.findGeofencesContainingLocation(latitude, longitude);
//     // }

//     // public GeofenceZone update(Long id, GeofenceZoneDto dto) {
//     //     GeofenceZone existing = geofenceRepository.findById(id)
//     //             .orElseThrow(() -> new RuntimeException("Geofence not found"));

//     //     existing.setName(dto.getName());
//     //     existing.setDescription(dto.getDescription());
//     //     existing.setLatitude(dto.getLatitude());
//     //     existing.setLongitude(dto.getLongitude());
//     //     existing.setRadius(dto.getRadius());
//     //     existing.setFenceType(dto.getFenceType());
//     //     existing.setIsActive(dto.getIsActive());
//     //     existing.setUpdatedAt(LocalDateTime.now());
//     //     existing.setUpdatedBy(dto.getUpdatedBy());

//     //     return geofenceRepository.save(existing);
//     // }

//     // public void delete(Long id) {
//     //     geofenceRepository.deleteById(id);
//     // }

//     // public GeofenceZoneDto toDto(GeofenceZone geofence) {
//     //     return GeofenceZoneDto.builder()
//     //             .id(geofence.getId())
//     //             .organizationId(geofence.getOrganization().getId())
//     //             .organizationName(geofence.getOrganization().getName())
//     //             .name(geofence.getName())
//     //             .description(geofence.getDescription())
//     //             .latitude(geofence.getLatitude())
//     //             .longitude(geofence.getLongitude())
//     //             .radius(geofence.getRadius())
//     //             .fenceType(geofence.getFenceType())
//     //             .isActive(geofence.getIsActive())
//     //             .build();
//     // }
// }
