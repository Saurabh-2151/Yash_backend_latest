package com.company.attendance.dto;
import lombok.Data;
@Data
public class FormDto {
    private Long id;
    private String name;
    private String schema;
    private Long createdBy;
    private Boolean isActive;
}

