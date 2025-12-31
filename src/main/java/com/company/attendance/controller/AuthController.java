// package com.company.attendance.controller;

// import com.company.attendance.dto.LoginRequest;
// import com.company.attendance.dto.LoginResponse;
// import com.company.attendance.entity.Employee;
// import com.company.attendance.entity.Employee.Status;
// import com.company.attendance.repository.EmployeeRepository;
// import com.company.attendance.service.AuthService;
// import com.company.attendance.service.JwtService;
// import jakarta.validation.Valid;
// import lombok.RequiredArgsConstructor;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController
// @RequestMapping("/api/auth")
// @RequiredArgsConstructor
// @CrossOrigin(origins = "*")
// public class AuthController {
    
//     // private final AuthService authService;
//     // private final JwtService jwtService;
//     // private final EmployeeRepository employeeRepository;
    
//     // @PostMapping("/login")
//     // public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
//     //     try {
//     //         // LoginResponse response = authService.login(loginRequest);
//     //         // return ResponseEntity.ok(response);
//     //     } catch (RuntimeException e) {
//     //         // return ResponseEntity.badRequest().build();
//     //     }
//     // }
    
//     // @PostMapping("/register")
//     // public ResponseEntity<?> register() {
//     //     // return ResponseEntity.ok().body("Registration endpoint - to be implemented");
//     // }
    
//     // @PostMapping("/register-test")
// //     // public ResponseEntity<?> registerTest() {
// //     //     try {
// //     //         // Create a test employee with known password
// //     //         // Employee testEmployee = Employee.builder()
// //     //         //         .firstName("Test")
// //     //         //         .lastName("User")
// //     //         //         .email("test@test.com")
// //     //         //         .employeeId("TEST001")
// //     //         //         .userId("testuser")
// //     //         //         .phone("1234567890")
// //     //         //         .status(Status.ACTIVE)
// //     //         //         .attendanceAllowed(true)
// //     //         //         .passwordHash("$2a$10$N.zmdr9k7uKQd4vK5M2tJ5O6I4k5M2tJ5O6I4k5M2tJ5O6I4k5M2tJ5O6I") // password: "password123"
// //     //         //         .build();
        
// //     //         // employeeRepository.save(testEmployee);
// //     //         // return ResponseEntity.ok().body("Test user created successfully");
// //     //     } catch (Exception e) {
// //     //         // return ResponseEntity.badRequest().body("Error creating test user: " + e.getMessage());
// //     //     }
// //     // }
    
// //     // @GetMapping("/profile")
// //     // public ResponseEntity<Map<String, Object>> getProfile(@RequestHeader("Authorization") String authHeader) {
// //     //     try {
// //     //         if (authHeader != null && authHeader.startsWith("Bearer ")) {
// //     //             String token = authHeader.substring(7);
// //     //             if (jwtService.validateToken(token)) {
// //     //                 String email = jwtService.extractUsername(token);
// //     //                 Map<String, Object> profile = authService.getUserProfile(email);
// //     //                 return ResponseEntity.ok(profile);
// //     //             }
// //     //         }
// //     //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
// //     //     } catch (Exception e) {
// //     //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
// //     //     }
// //     // }
    
// //     // @PostMapping("/validate")
// //     // public ResponseEntity<Map<String, Object>> validateToken(@RequestHeader("Authorization") String authHeader) {
// //     //     try {
// //     //         if (authHeader != null && authHeader.startsWith("Bearer ")) {
// //     //             String token = authHeader.substring(7);
// //     //             if (jwtService.validateToken(token)) {
// //     //                 Map<String, Object> userInfo = jwtService.extractUserInfo(token);
// //     //                 return ResponseEntity.ok(userInfo);
// //     //             }
// //     //         }
// //     //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
// //     //     } catch (Exception e) {
// //     //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
// //     //     }
// //     // }
// // }
