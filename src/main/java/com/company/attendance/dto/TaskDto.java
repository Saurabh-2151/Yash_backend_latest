package com.company.attendance.dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Long assignedTo;
    private Long assignedBy;
    private LocalDate dueDate;
    private String status;
    private String priority;
    private LocalDate createdAt;
}

