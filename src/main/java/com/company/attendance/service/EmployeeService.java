package com.company.attendance.service;

import com.company.attendance.entity.Employee;
import com.company.attendance.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setCreatedAt(LocalDateTime.now());
        }
        employee.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Optional<Employee> findByUserId(String userId) {
        return employeeRepository.findByUserId(userId);
    }

    public Optional<Employee> findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findByIsActive(Boolean isActive) {
        if (isActive == null) {
            return employeeRepository.findAll();
        }
        Employee.Status status = isActive ? Employee.Status.ACTIVE : Employee.Status.INACTIVE;
        return employeeRepository.findByStatus(status);
    }

    @Transactional
    public Employee update(Long id, Employee updated) {
        Employee existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        updated.setId(id);
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());
        return employeeRepository.save(updated);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public boolean existsByUserId(String userId) {
        return employeeRepository.existsByUserId(userId);
    }

    public boolean existsByEmployeeId(String employeeId) {
        return employeeRepository.existsByEmployeeId(employeeId);
    }
}
