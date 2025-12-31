package com.company.attendance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String code;

    private String logo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String contactEmail;
    private String contactPhone;
    private String website;
    private String industry;
    private String timezone;
    private String dateFormat;
    private String timeFormat;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long createdBy;
    private Long updatedBy;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Team> teams;
}
