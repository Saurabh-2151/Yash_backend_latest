package com.company.attendance.mapper;

import com.company.attendance.dto.DesignationDto;
import com.company.attendance.entity.Designation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DesignationMapper {
    DesignationMapper INSTANCE = Mappers.getMapper(DesignationMapper.class);

    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "organization", ignore = true)
    Designation toEntity(DesignationDto dto);
    
    DesignationDto toDto(Designation entity);
}
