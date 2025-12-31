package com.company.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "`schema`", columnDefinition = "TEXT")
    private String schema;
    private Long createdBy;
    private Boolean isActive;
}
