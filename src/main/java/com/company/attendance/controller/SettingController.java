package com.company.attendance.controller;
import com.company.attendance.dto.SettingDto;
import com.company.attendance.entity.Setting;
import com.company.attendance.mapper.SettingMapper;
import com.company.attendance.service.SettingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {
    private final SettingService settingService;
    private final SettingMapper settingMapper;
    @GetMapping
    public ResponseEntity<List<SettingDto>> listSettings() {
        var settings = settingService.findAll();
        var dtos = settings.stream().map(settingMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SettingDto> getSetting(@PathVariable Long id) {
        return ResponseEntity.ok(settingMapper.toDto(settingService.getById(id)));
    }
    @PostMapping
    public ResponseEntity<SettingDto> createSetting(@Valid @RequestBody SettingDto dto) {
        Setting setting = settingService.save(settingMapper.toEntity(dto));
        return ResponseEntity.ok(settingMapper.toDto(setting));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SettingDto> updateSetting(@PathVariable Long id, @RequestBody SettingDto dto) {
        Setting o = settingService.getById(id);
        Setting saved = settingService.save(settingMapper.toEntity(dto));
        return ResponseEntity.ok(settingMapper.toDto(saved));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSetting(@PathVariable Long id) {
        settingService.delete(id);
        return ResponseEntity.ok().build();
    }
}

