package com.company.attendance.dto;

import lombok.Data;

@Data
public class TeamDto {
    private Long id;
    private String name;
    private Long clientId;
    private String address;
    private String city;
    private String state;
    private String pincode;
}

