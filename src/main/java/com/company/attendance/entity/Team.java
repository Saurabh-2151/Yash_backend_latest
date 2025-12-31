package com.company.attendance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String description;
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_lead_id")
    private Employee teamLead;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Explicit getters used by TestController (defensive if Lombok is not processed)

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
