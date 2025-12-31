package com.company.attendance.service;

// Temporarily disabled to fix compilation issues
// import com.company.attendance.entity.Permission;
// import com.company.attendance.repository.PermissionRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class PermissionService {
    
//     private final PermissionRepository permissionRepository;

//     public List<Permission> findAll() {
//         return permissionRepository.findAll();
//     }

//     public Optional<Permission> findById(Long id) {
//         return permissionRepository.findById(id);
//     }

//     public Optional<Permission> findByName(String name) {
//         return permissionRepository.findByName(name);
//     }

//     @Transactional
//     public Permission save(Permission permission) {
//         if (permission.getId() == null) {
//             permission.setCreatedAt(LocalDateTime.now());
//         }
//         permission.setUpdatedAt(LocalDateTime.now());
//         return permissionRepository.save(permission);
//     }

//     @Transactional
//     public Permission update(Long id, Permission updated) {
//         Permission existing = findById(id)
//                 .orElseThrow(() -> new RuntimeException("Permission not found"));
//         updated.setId(id);
//         updated.setCreatedAt(existing.getCreatedAt());
//         updated.setUpdatedAt(LocalDateTime.now());
//         return permissionRepository.save(updated);
//     }

//     public void delete(Long id) {
//         permissionRepository.deleteById(id);
//     }

//     public List<Permission> findByModule(String module) {
//         return permissionRepository.findByModule(module);
//     }

//     public List<Permission> findByIsActive(Boolean isActive) {
//         return permissionRepository.findByIsActive(isActive);
//     }

//     public boolean existsByName(String name) {
//         return permissionRepository.existsByName(name);
//     }
// }
