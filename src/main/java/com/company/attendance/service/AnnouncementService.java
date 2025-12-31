package com.company.attendance.service;

import com.company.attendance.entity.Announcement;
import com.company.attendance.repository.AnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnouncementService {
    private final AnnouncementRepository announcementRepository;

    public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }

    public Optional<Announcement> findById(Long id) {
        return announcementRepository.findById(id);
    }

    public List<Announcement> findActiveAnnouncements(Long organizationId) {
        return announcementRepository.findActiveAnnouncements(organizationId, LocalDateTime.now());
    }

    public List<Announcement> findActiveAnnouncementsByType(Long organizationId, String type) {
        return announcementRepository.findActiveAnnouncementsByType(organizationId, type, LocalDateTime.now());
    }

    @Transactional
    public Announcement save(Announcement announcement) {
        if (announcement.getId() == null) {
            announcement.setCreatedAt(LocalDateTime.now());
        }
        announcement.setUpdatedAt(LocalDateTime.now());
        return announcementRepository.save(announcement);
    }

    @Transactional
    public Announcement update(Long id, Announcement updated) {
        Announcement existing = findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found"));
        updated.setId(id);
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());
        return announcementRepository.save(updated);
    }

    public void delete(Long id) {
        announcementRepository.deleteById(id);
    }
}
