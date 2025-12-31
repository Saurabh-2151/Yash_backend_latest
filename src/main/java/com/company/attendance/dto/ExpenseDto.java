package com.company.attendance.dto;
import lombok.Data;
@Data
public class ExpenseDto {
    private Long id;
    private Long employeeId;
    private Double amount;
    private String category;
    private String receiptUrl;
    private Long approvedBy;
    private String status;
}

