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

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> findByPhone(String phone) {
        return employeeRepository.findByPhone(phone);
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
        System.out.println("=== EMPLOYEE UPDATE DEBUG ===");
        System.out.println("Updating employee ID: " + id);
        System.out.println("Updated data: " + updated);
        
        Employee existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        System.out.println("Existing data: " + existing);
        
        // Update only the fields that exist in the Employee entity
        // IMPORTANT: Never update created_at and created_by during update
        if (updated.getFirstName() != null && !updated.getFirstName().equals(existing.getFirstName())) {
            System.out.println("Updating firstName from '" + existing.getFirstName() + "' to '" + updated.getFirstName() + "'");
            existing.setFirstName(updated.getFirstName());
        }
        if (updated.getLastName() != null && !updated.getLastName().equals(existing.getLastName())) {
            System.out.println("Updating lastName from '" + existing.getLastName() + "' to '" + updated.getLastName() + "'");
            existing.setLastName(updated.getLastName());
        }
        if (updated.getEmail() != null && !updated.getEmail().equals(existing.getEmail())) {
            System.out.println("Updating email from '" + existing.getEmail() + "' to '" + updated.getEmail() + "'");
            existing.setEmail(updated.getEmail());
        }
        if (updated.getPhone() != null && !updated.getPhone().equals(existing.getPhone())) {
            System.out.println("Updating phone from '" + existing.getPhone() + "' to '" + updated.getPhone() + "'");
            existing.setPhone(updated.getPhone());
        }
        if (updated.getEmployeeId() != null && !updated.getEmployeeId().equals(existing.getEmployeeId())) {
            existing.setEmployeeId(updated.getEmployeeId());
        }
        if (updated.getUserId() != null && !updated.getUserId().equals(existing.getUserId())) {
            existing.setUserId(updated.getUserId());
        }
        if (updated.getEmployeeCode() != null && !updated.getEmployeeCode().equals(existing.getEmployeeCode())) {
            existing.setEmployeeCode(updated.getEmployeeCode());
        }
        if (updated.getRole() != null && !updated.getRole().equals(existing.getRole())) {
            existing.setRole(updated.getRole());
        }
        if (updated.getReportingManager() != null && !updated.getReportingManager().equals(existing.getReportingManager())) {
            existing.setReportingManager(updated.getReportingManager());
        }
        if (updated.getTeam() != null && !updated.getTeam().equals(existing.getTeam())) {
            existing.setTeam(updated.getTeam());
        }
        if (updated.getDepartment() != null && !updated.getDepartment().equals(existing.getDepartment())) {
            existing.setDepartment(updated.getDepartment());
        }
        if (updated.getDesignation() != null && !updated.getDesignation().equals(existing.getDesignation())) {
            existing.setDesignation(updated.getDesignation());
        }
        if (updated.getStatus() != null && !updated.getStatus().equals(existing.getStatus())) {
            existing.setStatus(updated.getStatus());
        }
        if (updated.getAttendanceAllowed() != null && !updated.getAttendanceAllowed().equals(existing.getAttendanceAllowed())) {
            existing.setAttendanceAllowed(updated.getAttendanceAllowed());
        }
        if (updated.getHiredAt() != null && !updated.getHiredAt().equals(existing.getHiredAt())) {
            existing.setHiredAt(updated.getHiredAt());
        }
        if (updated.getTerminationDate() != null && !updated.getTerminationDate().equals(existing.getTerminationDate())) {
            existing.setTerminationDate(updated.getTerminationDate());
        }
        if (updated.getPasswordHash() != null && !updated.getPasswordHash().equals(existing.getPasswordHash())) {
            existing.setPasswordHash(updated.getPasswordHash());
        }
        if (updated.getOrganization() != null && !updated.getOrganization().equals(existing.getOrganization())) {
            existing.setOrganization(updated.getOrganization());
        }
        if (updated.getShift() != null && !updated.getShift().equals(existing.getShift())) {
            existing.setShift(updated.getShift());
        }
        if (updated.getLocationLat() != null && !updated.getLocationLat().equals(existing.getLocationLat())) {
            existing.setLocationLat(updated.getLocationLat());
        }
        if (updated.getLocationLng() != null && !updated.getLocationLng().equals(existing.getLocationLng())) {
            existing.setLocationLng(updated.getLocationLng());
        }
        if (updated.getSubadminId() != null && !updated.getSubadminId().equals(existing.getSubadminId())) {
            existing.setSubadminId(updated.getSubadminId());
        }
        if (updated.getProfileImageUrl() != null && !updated.getProfileImageUrl().equals(existing.getProfileImageUrl())) {
            existing.setProfileImageUrl(updated.getProfileImageUrl());
        }
        
        // IMPORTANT: Only update updated_at, never touch created_at and created_by
        existing.setUpdatedAt(LocalDateTime.now());
        
        System.out.println("Final existing data before save: " + existing);
        Employee saved = employeeRepository.save(existing);
        System.out.println("Saved data: " + saved);
        System.out.println("=== END EMPLOYEE UPDATE DEBUG ===");
        
        return saved;
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
