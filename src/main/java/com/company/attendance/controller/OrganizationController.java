package com.company.attendance.controller;

import com.company.attendance.dto.OrganizationDto;
import com.company.attendance.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
@Tag(name = "Organization Management", description = "APIs for managing organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping
    @Operation(summary = "Get all organizations with pagination")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved organizations")
    public ResponseEntity<Page<OrganizationDto>> getAllOrganizations(
            @Parameter(description = "Pagination and sorting parameters") 
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<OrganizationDto> organizations = organizationService.getAllOrganizations(pageable);
        return ResponseEntity.ok(organizations);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get organization by ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved organization")
    @ApiResponse(responseCode = "404", description = "Organization not found")
    public ResponseEntity<OrganizationDto> getOrganizationById(
            @Parameter(description = "ID of the organization to be retrieved") 
            @PathVariable Long id) {
        
        OrganizationDto organization = organizationService.getOrganizationById(id);
        return ResponseEntity.ok(organization);
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get organization by code")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved organization")
    @ApiResponse(responseCode = "404", description = "Organization not found")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(
            @Parameter(description = "Code of the organization to be retrieved")
            @PathVariable String code) {
        
        OrganizationDto organization = organizationService.getOrganizationByCode(code);
        return ResponseEntity.ok(organization);
    }

    @PostMapping
    @Operation(summary = "Create a new organization")
    @ApiResponse(responseCode = "201", description = "Organization created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ResponseEntity<OrganizationDto> createOrganization(
            @Parameter(description = "Organization data to create") 
            @Valid @RequestBody OrganizationDto organizationDto) {
        
        OrganizationDto createdOrganization = organizationService.createOrganization(organizationDto);
        return new ResponseEntity<>(createdOrganization, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing organization")
    @ApiResponse(responseCode = "200", description = "Organization updated successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Organization not found")
    public ResponseEntity<OrganizationDto> updateOrganization(
            @Parameter(description = "ID of the organization to be updated") 
            @PathVariable Long id,
            @Parameter(description = "Updated organization data") 
            @Valid @RequestBody OrganizationDto organizationDto) {
        
        OrganizationDto updatedOrganization = organizationService.updateOrganization(id, organizationDto);
        return ResponseEntity.ok(updatedOrganization);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an organization")
    @ApiResponse(responseCode = "204", description = "Organization deleted successfully")
    @ApiResponse(responseCode = "404", description = "Organization not found")
    public ResponseEntity<Void> deleteOrganization(
            @Parameter(description = "ID of the organization to be deleted") 
            @PathVariable Long id) {
        
        organizationService.deleteOrganization(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Activate/Deactivate an organization")
    @ApiResponse(responseCode = "200", description = "Organization status updated successfully")
    @ApiResponse(responseCode = "404", description = "Organization not found")
    public ResponseEntity<OrganizationDto> updateOrganizationStatus(
            @Parameter(description = "ID of the organization")
            @PathVariable Long id,
            @Parameter(description = "New status (true=active, false=inactive)")
            @RequestParam boolean active) {
        
        OrganizationDto updatedOrganization = organizationService.activateOrganization(id, active);
        return ResponseEntity.ok(updatedOrganization);
    }

    @GetMapping("/search")
    @Operation(summary = "Search organizations with filters")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved organizations")
    public ResponseEntity<Page<OrganizationDto>> searchOrganizations(
            @Parameter(description = "Name filter (partial match, case-insensitive)")
            @RequestParam(required = false) String name,
            @Parameter(description = "Code filter (exact match, case-insensitive)")
            @RequestParam(required = false) String code,
            @Parameter(description = "Industry filter (exact match, case-insensitive)")
            @RequestParam(required = false) String industry,
            @Parameter(description = "Active status filter")
            @RequestParam(required = false) Boolean isActive,
            @Parameter(description = "Pagination and sorting parameters")
            @PageableDefault(size = 20) Pageable pageable) {
        
        Page<OrganizationDto> organizations = organizationService.searchOrganizations(
                name, code, industry, isActive, pageable);
        return ResponseEntity.ok(organizations);
    }
}