package com.company.attendance.service;

import com.company.attendance.dto.ShiftDto;
import com.company.attendance.entity.Shift;
import com.company.attendance.mapper.ShiftMapper;
import com.company.attendance.repository.ShiftRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// @Slf4j
// public class ShiftService {
    
//     private final ShiftRepository shiftRepository;
//     private final ShiftMapper shiftMapper;

//     // public List<Shift> findAll() {
//     //     return shiftRepository.findAll();
//     // }

//     // public Optional<Shift> findById(Long id) {
//     //     return shiftRepository.findById(id);
//     // }

//     // public List<Shift> findByOrganizationId(Long organizationId) {
//     //     // For now, return all active shifts since we commented out the organization-specific method
//     //     return shiftRepository.findByIsActive(true);
//     // }

//     // public List<ShiftDto> getActiveShiftsByOrganization(Long organizationId) {
//     //     log.info("Fetching active shifts for organization ID: {}", organizationId);
        
//     //     // Use query to find active shifts
//     //     List<Shift> shifts = shiftRepository.findByIsActive(true);
//     //     return shiftMapper.toDtoList(shifts);
//     // }

//     // @Transactional
//     // public Shift save(Shift shift) {
//     //     if (shift.getId() == null) {
//     //         shift.setCreatedAt(LocalDateTime.now());
//     //     }
//     //     shift.setUpdatedAt(LocalDateTime.now());
//     //     return shiftRepository.save(shift);
//     // }

//     // @Transactional
//     // public Shift update(Long id, Shift updated) {
//     //     Shift existing = findById(id)
//     //             .orElseThrow(() -> new RuntimeException("Shift not found"));
//     //     updated.setId(id);
//     //     updated.setCreatedAt(existing.getCreatedAt());
//     //     updated.setUpdatedAt(LocalDateTime.now());
//     //     return shiftRepository.save(updated);
//     // }

//     // public void delete(Long id) {
//     //     shiftRepository.deleteById(id);
//     // }

//     // public List<Shift> findByIsActive(Boolean isActive) {
//     //     return shiftRepository.findByIsActive(isActive);
//     // }
// }
