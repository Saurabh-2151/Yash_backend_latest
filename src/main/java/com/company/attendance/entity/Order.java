package com.company.attendance.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private Long clientId;
    @Column(columnDefinition = "TEXT")
    private String items;
    private Double amount;
    private String status;
    private Long createdBy;
}
