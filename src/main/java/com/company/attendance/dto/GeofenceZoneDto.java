package com.company.attendance.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeofenceZoneDto {
    private Long id;
    private Long organizationId;
    private String organizationName;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private Double radius;
    private String fenceType;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
}
