package com.company.attendance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDto extends BaseDto {
    @NotBlank(message = "Organization name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    @NotBlank(message = "Organization code is required")
    @Pattern(regexp = "^[A-Z0-9_-]+$", message = "Code can only contain uppercase letters, numbers, hyphens and underscores")
    private String code;
    private String logo;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pincode;
    @Email(message = "Contact email should be valid")
    private String contactEmail;
    
    @Pattern(regexp = "^[+]*[(]?[0-9]{1,4}[)]?[-\\s\\./0-9]*$", message = "Invalid phone number format")
    private String contactPhone;
    @Pattern(regexp = "^(https?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?$", message = "Invalid website URL")
    private String website;
    
    private String industry;
    private String description;
    private String timezone;
    private String dateFormat;
    private String timeFormat;
    private String currency;
    private String taxId;
    private String registrationNumber;
    private String fiscalYearStart;
    private String fiscalYearEnd;
    private String primaryColor;
    private String secondaryColor;
    private Boolean isActive;
}
