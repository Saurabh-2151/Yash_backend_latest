package com.company.attendance.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShiftDto {
    private Long id;
    private String name;
    private String code;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime breakStartTime;
    private LocalTime breakEndTime;
    private Integer gracePeriodInMinutes;
    private Integer overtimeThresholdInMinutes;
    private Boolean isOverTimeAllowed;
    private Boolean isActive;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    private Long organizationId;
}
