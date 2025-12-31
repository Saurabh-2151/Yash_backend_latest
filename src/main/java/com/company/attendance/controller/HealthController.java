package com.company.attendance.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "Backend is running successfully!";
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> status() {
        Map<String, String> status = new HashMap<>();
        status.put("status", "UP");
        status.put("service", "Attendance Backend");
        status.put("version", "1.0.0");
        return ResponseEntity.ok(status);
    }
}
