package com.company.attendance.controller;

import com.company.attendance.entity.Employee;
import com.company.attendance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TestController {
    
    private final EmployeeRepository employeeRepository;
    
    @GetMapping("/health")
    public String health() {
        return "Backend is running!";
    }
    
    @GetMapping("/employees")
    public ResponseEntity<List<Map<String, Object>>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        List<Map<String, Object>> dtos = employees.stream().map(e -> {
            Map<String, Object> m = new HashMap<>();
            m.put("id", e.getId());
            m.put("userId", e.getUserId());
            m.put("employeeId", e.getEmployeeId());
            m.put("firstName", e.getFirstName());
            m.put("lastName", e.getLastName());
            m.put("email", e.getEmail());
            m.put("phone", e.getPhone());

            if (e.getTeam() != null) {
                Map<String, Object> team = new HashMap<>();
                team.put("id", e.getTeam().getId());
                team.put("name", e.getTeam().getName());
                m.put("team", team);
            }

            if (e.getRole() != null) {
                Map<String, Object> role = new HashMap<>();
                role.put("id", e.getRole().getId());
                role.put("name", e.getRole().getName());
                m.put("role", role);
            }

            return m;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
