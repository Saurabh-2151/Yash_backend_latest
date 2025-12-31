// package com.company.attendance.service;

// import com.company.attendance.entity.Policy;
// import com.company.attendance.repository.PolicyRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class PolicyService {
//     // private final PolicyRepository policyRepository;

//     // public List<Policy> findAll() {
//     //     return policyRepository.findAll();
//     // }

//     // public Optional<Policy> findById(Long id) {
//     //     return policyRepository.findById(id);
//     // }

//     // public List<Policy> findByOrganizationId(Long organizationId) {
//     //     // For now, return all active policies since we commented out the organization-specific method
//     //     return policyRepository.findByTypeAndIsActive("", true);
//     // }

//     // public List<Policy> findByType(String type) {
//     //     return policyRepository.findByTypeAndIsActive(type, true);
//     // }

//     // @Transactional
//     // public Policy save(Policy policy) {
//     //     if (policy.getId() == null) {
//     //         policy.setCreatedAt(LocalDateTime.now());
//     //     }
//     //     policy.setUpdatedAt(LocalDateTime.now());
//     //     return policyRepository.save(policy);
//     // }

//     // @Transactional
//     // public Policy update(Long id, Policy updated) {
//     //     Policy existing = findById(id)
//     //             .orElseThrow(() -> new RuntimeException("Policy not found"));
//     //     updated.setId(id);
//     //     updated.setCreatedAt(existing.getCreatedAt());
//     //     updated.setUpdatedAt(LocalDateTime.now());
//     //     return policyRepository.save(updated);
//     // }

//     // public void delete(Long id) {
//     //     policyRepository.deleteById(id);
//     // }
// }
