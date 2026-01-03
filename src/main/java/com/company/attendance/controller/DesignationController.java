package com.company.attendance.controller;

import com.company.attendance.dto.DesignationDto;
import com.company.attendance.entity.Designation;
import com.company.attendance.mapper.DesignationMapper;
import com.company.attendance.service.DesignationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/designations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DesignationController {

    private final DesignationService designationService;
    private final DesignationMapper designationMapper;

    @GetMapping
    public ResponseEntity<List<DesignationDto>> getAllDesignations() {
        List<Designation> designations = designationService.findAll();
        List<DesignationDto> dtos = designations.stream()
                .map(designationMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesignationDto> getDesignationById(@PathVariable Long id) {
        return designationService.findById(id)
                .map(designationMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DesignationDto> createDesignation(@Valid @RequestBody DesignationDto dto) {
        Designation designation = designationMapper.toEntity(dto);
        Designation saved = designationService.save(designation);
        return ResponseEntity.ok(designationMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignationDto> updateDesignation(@PathVariable Long id, @Valid @RequestBody DesignationDto dto) {
        Designation designation = designationMapper.toEntity(dto);
        designation.setId(id);
        Designation updated = designationService.update(id, designation);
        return ResponseEntity.ok(designationMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDesignation(@PathVariable Long id) {
        designationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}