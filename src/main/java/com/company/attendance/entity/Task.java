package com.company.attendance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
