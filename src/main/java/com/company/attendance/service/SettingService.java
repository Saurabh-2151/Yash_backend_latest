package com.company.attendance.service;
import com.company.attendance.entity.Setting;
import com.company.attendance.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SettingService {
    private final SettingRepository settingRepository;
    public Setting save(Setting setting) { return settingRepository.save(setting); }
    public List<Setting> findAll() { return settingRepository.findAll(); }
    public Setting getById(Long id) { return settingRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { settingRepository.deleteById(id); }
}

