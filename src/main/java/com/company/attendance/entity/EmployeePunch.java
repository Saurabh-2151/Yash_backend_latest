package com.company.attendance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee_punch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeePunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "punch_type", nullable = false)
    @NotBlank
    private String punchType; // IN, OUT, BREAK_IN, BREAK_OUT

    @Column(name = "punch_time", nullable = false)
    private LocalDateTime punchTime;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "altitude")
    private Double altitude;

    @Column(name = "accuracy")
    private Double accuracy;

    @Column(name = "location_address")
    private String locationAddress;

    @Column(name = "is_within_geofence")
    private Boolean isWithinGeofence;

    @Column(name = "geofence_id")
    private Long geofenceId;

    @Column(name = "device_info")
    private String deviceInfo;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "notes")
    private String notes;

    @Column(name = "is_manual_punch")
    private Boolean isManualPunch = false;

    @Column(name = "approved_by")
    private Long approvedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
