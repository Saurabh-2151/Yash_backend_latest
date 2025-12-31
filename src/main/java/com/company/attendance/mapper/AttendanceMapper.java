package com.company.attendance.mapper;

import com.company.attendance.dto.AttendanceDto;
import com.company.attendance.entity.Attendance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {
    AttendanceMapper INSTANCE = Mappers.getMapper(AttendanceMapper.class);

    @Mapping(target = "employeeId", ignore = true)
    AttendanceDto toDto(Attendance attendance);
    
    @Mapping(target = "id", ignore = true)
    Attendance toEntity(AttendanceDto dto);
}

