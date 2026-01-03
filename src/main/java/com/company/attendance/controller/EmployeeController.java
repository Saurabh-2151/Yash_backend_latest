package com.company.attendance.controller;

import com.company.attendance.dto.EmployeeDto;
import com.company.attendance.entity.Employee;
import com.company.attendance.mapper.EmployeeMapper;
import com.company.attendance.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> listEmployees() {
        List<Employee> employees = employeeService.findAll();
        List<EmployeeDto> dtos = employees.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        return employeeService.findById(id)
                .map(employeeMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeDto dto) {
        try {
            System.out.println("Received employee creation request: " + dto);
            
            // Set default values for required fields if not provided
            if (dto.getFirstName() == null || dto.getFirstName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "First name is required"));
            }
            
            if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "Email is required"));
            }
            
            // Set default status if not provided
            if (dto.getStatus() == null) {
                dto.setStatus("ACTIVE");
            }
            
            // Set default organization if not provided
            if (dto.getOrganizationId() == null) {
                dto.setOrganizationId(1L);
            }
            
            // Generate userId if not provided
            if (dto.getUserId() == null || dto.getUserId().trim().isEmpty()) {
                dto.setUserId("emp_" + System.currentTimeMillis());
            }
            
            // Generate employeeId if not provided
            if (dto.getEmployeeId() == null || dto.getEmployeeId().trim().isEmpty()) {
                dto.setEmployeeId("EMP_" + System.currentTimeMillis());
            }
            
            Employee employee = employeeMapper.toEntity(dto);
            Employee saved = employeeService.save(employee);
            return ResponseEntity.ok(employeeMapper.toDto(saved));
            
        } catch (Exception e) {
            System.err.println("Error creating employee: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(Map.of("error", "Failed to create employee: " + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDto dto) {
        System.out.println("=== CONTROLLER UPDATE DEBUG ===");
        System.out.println("Updating employee ID: " + id);
        System.out.println("Received DTO: " + dto);
        
        Employee employee = employeeMapper.toEntity(dto);
        System.out.println("Mapped to Entity: " + employee);
        
        Employee updated = employeeService.update(id, employee);
        System.out.println("Updated employee: " + updated);
        
        EmployeeDto responseDto = employeeMapper.toDto(updated);
        System.out.println("Response DTO: " + responseDto);
        System.out.println("=== END CONTROLLER UPDATE DEBUG ===");
        
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/upload-image")
    public ResponseEntity<?> uploadEmployeeImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file
    ) {
        try {
            // Validate file
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of(
                    "error", "Please select a file to upload"
                ));
            }

            // Validate file type (only images)
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return ResponseEntity.badRequest().body(Map.of(
                    "error", "Only image files are allowed"
                ));
            }

            // Save file (in real app, save to cloud storage or file system)
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            String imageUrl = "/uploads/employees/" + fileName;
            
            // For now, save to local uploads directory
            java.nio.file.Path uploadPath = java.nio.file.Paths.get("uploads/employees");
            if (!java.nio.file.Files.exists(uploadPath)) {
                java.nio.file.Files.createDirectories(uploadPath);
            }
            java.nio.file.Files.copy(file.getInputStream(), uploadPath.resolve(fileName));

            // Update employee with image URL
            Employee employee = employeeService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            employee.setProfileImageUrl(imageUrl);
            employeeService.update(id, employee);

            return ResponseEntity.ok(Map.of(
                    "message", "Image uploaded successfully",
                    "imageUrl", imageUrl
            ));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "error", "Failed to upload image: " + e.getMessage()
            ));
        }
    }
}
