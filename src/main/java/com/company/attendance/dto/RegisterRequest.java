package com.company.attendance.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String fullName;

    @Email
    @NotBlank
    private String email;

    private String phone;
    private String designation;
    private Long teamId;

    @NotBlank
    private String role;

    @NotBlank
    private String password;
}
