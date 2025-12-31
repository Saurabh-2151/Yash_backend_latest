// package com.company.attendance.service;

// import com.company.attendance.entity.Organization;
// import com.company.attendance.repository.OrganizationRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class OrganizationService {
//     // private final OrganizationRepository organizationRepository;

//     // public List<Organization> findAll() {
//     //     return organizationRepository.findAll();
//     // }

//     // public Optional<Organization> findById(Long id) {
//     //     return organizationRepository.findById(id);
//     // }

//     // public Optional<Organization> findByCode(String code) {
//     //     return organizationRepository.findByCode(code);
//     // }

//     // @Transactional
//     // public Organization save(Organization organization) {
//     //     if (organization.getId() == null) {
//     //         organization.setCreatedAt(LocalDateTime.now());
//     //     }
//     //     organization.setUpdatedAt(LocalDateTime.now());
//     //     return organizationRepository.save(organization);
//     // }

//     // @Transactional
//     // public Organization update(Long id, Organization updated) {
//     //     Organization existing = findById(id)
//     //             .orElseThrow(() -> new RuntimeException("Organization not found"));
//     //     updated.setId(id);
//     //     updated.setCreatedAt(existing.getCreatedAt());
//     //     updated.setUpdatedAt(LocalDateTime.now());
//     //     return organizationRepository.save(updated);
//     // }

//     // public void delete(Long id) {
//     //     organizationRepository.deleteById(id);
//     // }

//     // public List<Organization> findByIsActive(Boolean isActive) {
//     //     return organizationRepository.findByIsActive(isActive);
//     // }

//     // public boolean existsByCode(String code) {
//     //     return organizationRepository.existsByCode(code);
//     // }
// }
