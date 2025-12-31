package com.company.attendance.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrganizationDto {
    private Long id;
    private String name;
    private String code;
    private String logo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String contactEmail;
    private String contactPhone;
    private String website;
    private String industry;
    private String timezone;
    private String dateFormat;
    private String timeFormat;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;
}
