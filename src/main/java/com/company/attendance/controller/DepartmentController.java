package com.company.attendance.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DepartmentController {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> listDepartments() {
        // Return some default departments for now
        List<Map<String, Object>> departments = new ArrayList<>();
        
        Map<String, Object> dept1 = new HashMap<>();
        dept1.put("id", 1L);
        dept1.put("name", "Engineering");
        dept1.put("isActive", true);
        departments.add(dept1);
        
        Map<String, Object> dept2 = new HashMap<>();
        dept2.put("id", 2L);
        dept2.put("name", "Human Resources");
        dept2.put("isActive", true);
        departments.add(dept2);
        
        Map<String, Object> dept3 = new HashMap<>();
        dept3.put("id", 3L);
        dept3.put("name", "Sales");
        dept3.put("isActive", true);
        departments.add(dept3);
        
        Map<String, Object> dept4 = new HashMap<>();
        dept4.put("id", 4L);
        dept4.put("name", "Marketing");
        dept4.put("isActive", true);
        departments.add(dept4);
        
        Map<String, Object> dept5 = new HashMap<>();
        dept5.put("id", 5L);
        dept5.put("name", "Finance");
        dept5.put("isActive", true);
        departments.add(dept5);
        
        Map<String, Object> dept6 = new HashMap<>();
        dept6.put("id", 6L);
        dept6.put("name", "Operations");
        dept6.put("isActive", true);
        departments.add(dept6);
        
        return ResponseEntity.ok(departments);
    }
}