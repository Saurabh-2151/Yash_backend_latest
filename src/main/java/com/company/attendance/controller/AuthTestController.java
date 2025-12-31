package com.company.attendance.controller;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.entity.Employee;
// import com.company.attendance.entity.Employee.Status;
// import com.company.attendance.entity.Role;
// import com.company.attendance.repository.EmployeeRepository;
// import com.company.attendance.repository.RoleRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.CrossOrigin;

// @RestController
// @RequestMapping("/api/auth-test")
// @RequiredArgsConstructor
// @CrossOrigin(origins = "*")
// public class AuthTestController {
    
//     // private final EmployeeRepository employeeRepository;
//     // private final PasswordEncoder passwordEncoder;
//     // private final RoleRepository roleRepository;
    
//     // @PostMapping("/create-role-users")
//     // public ResponseEntity<?> createRoleUsers() {
//     //     try {
//     //         // Find or create roles
//     //         Role adminRole = roleRepository.findByName("ADMIN")
//     //                 .orElseGet(() -> {
//     //                     Role role = Role.builder()
//     //                             .name("ADMIN")
//     //                             .description("Administrator role")
//     //                             .isActive(true)
//     //                             .build();
//     //                     return roleRepository.save(role);
//     //                 });
            
//     //         Role managerRole = roleRepository.findByName("MANAGER")
//     //                 .orElseGet(() -> {
//     //                     Role role = Role.builder()
//     //                             .name("MANAGER")
//     //                             .description("Manager role")
//     //                             .isActive(true)
//     //                             .build();
//     //                     return roleRepository.save(role);
//     //                 });
            
//     //         Role employeeRole = roleRepository.findByName("EMPLOYEE")
//     //                 .orElseGet(() -> {
//     //                     Role role = Role.builder()
//     //                             .name("EMPLOYEE")
//     //                             .description("Employee role")
//     //                             .isActive(true)
//     //                             .build();
//     //                     return roleRepository.save(role);
//     //                 });
            
//     //         // Create admin user
//     //         Employee admin = Employee.builder()
//     //                 .firstName("Admin")
//     //                 .lastName("User")
//     //                 .email("admin@test.com")
//     //                 .employeeId("ADM001")
//     //                 .userId("admin")
//     //                 .phone("1234567890")
//     //                 .status(Status.ACTIVE)
//     //                 .attendanceAllowed(true)
//     //                 .passwordHash(passwordEncoder.encode("admin123"))
//     //                 .role(adminRole)
//     //                 .build();
            
//     //         // Create manager user
//     //         Employee manager = Employee.builder()
//     //                 .firstName("Manager")
//     //                 .lastName("User")
//     //                 .email("manager@test.com")
//     //                 .employeeId("MGR001")
//     //                 .userId("manager")
//     //                 .phone("1234567890")
//     //                 .status(Status.ACTIVE)
//     //                 .attendanceAllowed(true)
//     //                 .passwordHash(passwordEncoder.encode("manager123"))
//     //                 .role(managerRole)
//     //                 .build();
            
//     //         // Create regular employee user
//     //         Employee employee = Employee.builder()
//     //                 .firstName("Employee")
//     //                 .lastName("User")
//     //                 .email("employee@test.com")
//     //                 .employeeId("EMP001")
//     //                 .userId("employee")
//     //                 .phone("1234567890")
//     //                 .status(Status.ACTIVE)
//     //                 .attendanceAllowed(true)
//     //                 .passwordHash(passwordEncoder.encode("employee123"))
//     //                 .role(employeeRole)
//     //                 .build();
            
//     //         employeeRepository.saveAll(List.of(admin, manager, employee));
            
//     //         return ResponseEntity.ok("Created admin, manager, and employee users successfully");
//     //     } catch (Exception e) {
//     //         return ResponseEntity.badRequest().body("Error creating users: " + e.getMessage());
//     //     }
//     // }
// }
