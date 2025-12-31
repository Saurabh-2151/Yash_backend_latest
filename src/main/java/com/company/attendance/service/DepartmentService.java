package com.company.attendance.service;

import com.company.attendance.entity.Department;
import com.company.attendance.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// @Slf4j
// public class DepartmentService {
    
//     private final DepartmentRepository departmentRepository;

//     public List<Department> findAll() {
//         return departmentRepository.findAll();
//     }

//     public Optional<Department> findById(Long id) {
//         return departmentRepository.findById(id);
//     }

//     public Optional<Department> findByCode(String code) {
//         return departmentRepository.findByCode(code);
//     }

//     public List<Department> findByOrganizationId(Long organizationId) {
//         // For now, return all active departments since we commented out the organization-specific method
//         return departmentRepository.findByIsActive(true);
//     }

//     @Transactional
//     public Department save(Department department) {
//         if (department.getId() == null) {
//             department.setCreatedAt(LocalDateTime.now());
//         }
//         department.setUpdatedAt(LocalDateTime.now());
//         return departmentRepository.save(department);
//     }

//     @Transactional
//     public Department update(Long id, Department updated) {
//         Department existing = findById(id)
//                 .orElseThrow(() -> new RuntimeException("Department not found"));
//         updated.setId(id);
//         updated.setCreatedAt(existing.getCreatedAt());
//         updated.setUpdatedAt(LocalDateTime.now());
//         return departmentRepository.save(updated);
//     }

//     public void delete(Long id) {
//         departmentRepository.deleteById(id);
//     }

//     public List<Department> findByIsActive(Boolean isActive) {
//         return departmentRepository.findByIsActive(isActive);
//     }

//     public boolean existsByCode(String code) {
//         return departmentRepository.existsByCode(code);
//     }
// }
