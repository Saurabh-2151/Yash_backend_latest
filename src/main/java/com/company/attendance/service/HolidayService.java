// package com.company.attendance.service;

// import com.company.attendance.entity.Holiday;
// import com.company.attendance.repository.HolidayRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Optional;

// @Service
// @RequiredArgsConstructor
// public class HolidayService {
//     // private final HolidayRepository holidayRepository;

//     // public List<Holiday> findAll() {
//     //     return holidayRepository.findAll();
//     // }

//     // public Optional<Holiday> findById(Long id) {
//     //     return holidayRepository.findById(id);
//     // }

//     // public List<Holiday> findByOrganizationId(Long organizationId) {
//     //     // For now, return all holidays since we commented out the organization-specific method
//     //     return holidayRepository.findAll();
//     // }

//     // public List<Holiday> findByOrganizationIdAndDateRange(Long organizationId, LocalDate startDate, LocalDate endDate) {
//     //     // For now, return all holidays since we commented out the organization-specific method
//     //     return holidayRepository.findAll();
//     // }

//     // public Holiday findByOrganizationIdAndDate(Long organizationId, LocalDate date) {
//     //     return holidayRepository.findByOrganizationIdAndDate(organizationId, date);
//     // }

//     // @Transactional
//     // public Holiday save(Holiday holiday) {
//     //     if (holiday.getId() == null) {
//     //         holiday.setCreatedAt(LocalDateTime.now());
//     //     }
//     //     holiday.setUpdatedAt(LocalDateTime.now());
//     //     return holidayRepository.save(holiday);
//     // }

//     // @Transactional
//     // public Holiday update(Long id, Holiday updated) {
//     //     Holiday existing = findById(id)
//     //             .orElseThrow(() -> new RuntimeException("Holiday not found"));
//     //     updated.setId(id);
//     //     updated.setCreatedAt(existing.getCreatedAt());
//     //     updated.setUpdatedAt(LocalDateTime.now());
//     //     return holidayRepository.save(updated);
//     // }

//     // public void delete(Long id) {
//     //     holidayRepository.deleteById(id);
//     // }
// }
