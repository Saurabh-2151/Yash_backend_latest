package com.company.attendance.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDto {
    private Long id;
    private String name;
    private String description;
    private Boolean isActive;
    private Long clientId;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private Long teamLeadId;
    private Long parentTeamId;
    private List<Long> memberIds;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
    
    // Additional fields for frontend display
    private String teamLeadName;
    private Integer memberCount;
    private String parentTeamName;
}

