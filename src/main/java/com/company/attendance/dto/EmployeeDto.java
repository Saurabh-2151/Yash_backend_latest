package com.company.attendance.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String userId;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long roleId;
    private String roleName;
    private Long subadminId;
    private Long teamId;
    private String teamName;
    private Long designationId;
    private String designationName;
    private String status;
    private String profileImageUrl;
    private LocalDate hiredAt;
    private LocalDate terminationDate;
    private Long reportingManagerId;
    private String reportingManagerName;
    private Long organizationId;
    private String organizationName;
    private Long departmentId;
    private String departmentName;
    private Long shiftId;
    private String shiftName;
    private BigDecimal locationLat;
    private BigDecimal locationLng;
    private String employeeCode;
    private Boolean attendanceAllowed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
