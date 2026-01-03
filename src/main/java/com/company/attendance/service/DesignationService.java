package com.company.attendance.service;

import com.company.attendance.entity.Designation;
import com.company.attendance.repository.DesignationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DesignationService {
    private final DesignationRepository designationRepository;

    public List<Designation> findAll() {
        return designationRepository.findAll();
    }

    public Optional<Designation> findById(Long id) {
        return designationRepository.findById(id);
    }

    public Optional<Designation> findByCode(String code) {
        return designationRepository.findByCode(code);
    }

    public List<Designation> findByOrganizationId(Long organizationId) {
        // For now, return all active designations since we commented out the organization-specific method
        return designationRepository.findByIsActive(true);
    }

    @Transactional
    public Designation save(Designation designation) {
        if (designation.getId() == null) {
            designation.setCreatedAt(LocalDateTime.now());
        }
        designation.setUpdatedAt(LocalDateTime.now());
        return designationRepository.save(designation);
    }

    @Transactional
    public Designation update(Long id, Designation updated) {
        Designation existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Designation not found"));
        updated.setId(id);
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());
        return designationRepository.save(updated);
    }

    public void delete(Long id) {
        designationRepository.deleteById(id);
    }

    public List<Designation> findByIsActive(Boolean isActive) {
        return designationRepository.findByIsActive(isActive);
    }
}
