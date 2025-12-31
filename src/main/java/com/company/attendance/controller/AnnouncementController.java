package com.company.attendance.controller;

import com.company.attendance.dto.AnnouncementDto;
import com.company.attendance.entity.Announcement;
import com.company.attendance.mapper.AnnouncementMapper;
import com.company.attendance.service.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/announcements")
@RequiredArgsConstructor
public class AnnouncementController {
    
    private static final Logger log = LoggerFactory.getLogger(AnnouncementController.class);

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;

    @PostMapping
    public ResponseEntity<AnnouncementDto> createAnnouncement(@Valid @RequestBody AnnouncementDto announcementDto) {
        log.info("Creating announcement: {}", announcementDto.getTitle());
        
        Announcement announcement = announcementMapper.toEntity(announcementDto);
        announcement.setCreatedAt(LocalDateTime.now());
        
        Announcement created = announcementService.save(announcement);
        
        log.info("Announcement created successfully with ID: {}", created.getId());
        return ResponseEntity.ok(announcementMapper.toDto(created));
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementDto>> getAllAnnouncements() {
        log.info("Fetching all announcements");
        
        List<Announcement> announcements = announcementService.findAll();
        
        return ResponseEntity.ok(announcements.stream()
                .map(announcementMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/active/{organizationId}")
    public ResponseEntity<List<AnnouncementDto>> getActiveAnnouncements(@PathVariable Long organizationId) {
        log.info("Fetching active announcements for organization: {}", organizationId);
        
        List<Announcement> announcements = announcementService.findActiveAnnouncements(organizationId);
        
        return ResponseEntity.ok(announcements.stream()
                .map(announcementMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/active/{organizationId}/type/{type}")
    public ResponseEntity<List<AnnouncementDto>> getActiveAnnouncementsByType(@PathVariable Long organizationId,
                                                                              @PathVariable String type) {
        log.info("Fetching active announcements for organization: {} and type: {}", organizationId, type);
        
        List<Announcement> announcements = announcementService.findActiveAnnouncementsByType(organizationId, type);
        
        return ResponseEntity.ok(announcements.stream()
                .map(announcementMapper::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDto> getAnnouncementById(@PathVariable Long id) {
        log.info("Fetching announcement with ID: {}", id);
        
        Announcement announcement = announcementService.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        
        return ResponseEntity.ok(announcementMapper.toDto(announcement));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementDto> updateAnnouncement(
            @PathVariable Long id,
            @Valid @RequestBody AnnouncementDto announcementDto) {
        log.info("Updating announcement with ID: {}", id);
        
        Announcement existing = announcementService.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        
        announcementMapper.updateEntityFromDto(announcementDto, existing);
        existing.setUpdatedAt(LocalDateTime.now());
        
        Announcement updated = announcementService.save(existing);
        
        log.info("Announcement updated successfully with ID: {}", updated.getId());
        return ResponseEntity.ok(announcementMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        log.info("Deleting announcement with ID: {}", id);
        
        announcementService.delete(id);
        
        log.info("Announcement deleted successfully with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
