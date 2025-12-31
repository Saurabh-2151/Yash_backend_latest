package com.company.attendance.dto;
import lombok.Data;
@Data
public class OrderDto {
    private Long id;
    private String orderNumber;
    private Long clientId;
    private String items;
    private Double amount;
    private String status;
    private Long createdBy;
}

