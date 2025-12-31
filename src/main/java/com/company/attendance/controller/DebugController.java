package com.company.attendance.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/debug")
@CrossOrigin(origins = "*")
public class DebugController {
    
    @PostMapping("/test-login")
    public String testLogin(@RequestBody String loginRequest) {
        return "Received: " + loginRequest;
    }
    
    @GetMapping("/test-user")
    public String testUser() {
        return "Test user endpoint working";
    }
}
