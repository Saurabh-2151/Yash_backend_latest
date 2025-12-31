package com.company.attendance.dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class LeaveRequestDto {
    private Long id;
    private Long employeeId;
    private String leaveType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String status;
    private String reason;
}
