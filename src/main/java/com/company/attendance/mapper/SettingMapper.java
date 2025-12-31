package com.company.attendance.mapper;
import com.company.attendance.dto.SettingDto;
import com.company.attendance.entity.Setting;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface SettingMapper {
    SettingDto toDto(Setting o);
    Setting toEntity(SettingDto dto);
}

