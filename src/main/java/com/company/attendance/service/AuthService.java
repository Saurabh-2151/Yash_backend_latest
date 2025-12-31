package com.company.attendance.service;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.dto.LoginRequest;
// import com.company.attendance.dto.LoginResponse;
// import com.company.attendance.entity.Employee;
// import com.company.attendance.entity.Role;
// import com.company.attendance.repository.EmployeeRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.time.LocalDateTime;
// import java.util.HashMap;
// import java.util.Map;

// @Service
// @RequiredArgsConstructor
// public class AuthService {
    
//     // private final EmployeeRepository employeeRepository;
//     private final PasswordEncoder passwordEncoder;
//     // private final JwtService jwtService;
    
//     public LoginResponse login(LoginRequest loginRequest) {
//         // Find employee by email
//         Employee employee = employeeRepository.findByEmail(loginRequest.getEmail())
//                 .orElseThrow(() -> new RuntimeException("Invalid email or password"));
        
//         // Check if employee is active
//         if (employee.getStatus() == null || !"ACTIVE".equalsIgnoreCase(employee.getStatus().name())) {
//             throw new RuntimeException("Account is not active");
//         }
        
//         // Verify password (assuming password is stored as hash)
//         if (!passwordEncoder.matches(loginRequest.getPassword(), employee.getPasswordHash())) {
//             throw new RuntimeException("Invalid email or password");
//         }
        
//         // Get user role
//         String roleName = "EMPLOYEE"; // default
//         if (employee.getRole() != null) {
//             roleName = employee.getRole().getName().toUpperCase();
//         }
        
//         // Generate JWT token with role
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("userId", employee.getId());
//         claims.put("employeeId", employee.getEmployeeId());
//         claims.put("email", employee.getEmail());
//         claims.put("role", roleName);
//         claims.put("name", employee.getFirstName() + " " + employee.getLastName());
        
//         String token = jwtService.generateToken(claims, employee.getEmail());
        
//         // Update last login
//         employee.setUpdatedAt(LocalDateTime.now());
//         employeeRepository.save(employee);
        
//         return new LoginResponse(token, "Bearer", 3600); // 1 hour expiry
//     }
    
//     public Map<String, Object> getUserProfile(String email) {
//         Employee employee = employeeRepository.findByEmail(email)
//                 .orElseThrow(() -> new RuntimeException("User not found"));
        
//         Map<String, Object> profile = new HashMap<>();
//         profile.put("id", employee.getId());
//         profile.put("employeeId", employee.getEmployeeId());
//         profile.put("email", employee.getEmail());
//         profile.put("name", employee.getFirstName() + " " + employee.getLastName());
//         profile.put("firstName", employee.getFirstName());
//         profile.put("lastName", employee.getLastName());
//         profile.put("phone", employee.getPhone());
//         profile.put("profileImage", employee.getProfileImageUrl());
//         profile.put("status", employee.getStatus());
        
//         // Role information
//         if (employee.getRole() != null) {
//             profile.put("role", employee.getRole().getName());
//             profile.put("roleName", employee.getRole().getDisplayName());
//             profile.put("roleId", employee.getRole().getId());
//         } else {
//             profile.put("role", "EMPLOYEE");
//             profile.put("roleName", "Employee");
//             profile.put("roleId", null);
//         }
        
//         // Department information
//         if (employee.getDepartment() != null) {
//             profile.put("department", employee.getDepartment().getName());
//             profile.put("departmentId", employee.getDepartment().getId());
//         }
        
//         // Designation information
//         if (employee.getDesignation() != null) {
//             profile.put("designation", employee.getDesignation().getName());
//             profile.put("designationId", employee.getDesignation().getId());
//         }
        
//         return profile;
//     }
// }
