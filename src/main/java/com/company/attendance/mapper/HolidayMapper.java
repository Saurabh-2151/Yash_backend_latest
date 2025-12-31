package com.company.attendance.mapper;

import com.company.attendance.dto.HolidayDto;
import com.company.attendance.entity.Holiday;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HolidayMapper {
    HolidayMapper INSTANCE = Mappers.getMapper(HolidayMapper.class);

    @Mapping(target = "organization", ignore = true)
    Holiday toEntity(HolidayDto dto);
    
    HolidayDto toDto(Holiday entity);
}
