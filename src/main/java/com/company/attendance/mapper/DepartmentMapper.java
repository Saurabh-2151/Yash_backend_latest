package com.company.attendance.mapper;

import com.company.attendance.dto.DepartmentDto;
import com.company.attendance.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "organization", ignore = true)
    Department toEntity(DepartmentDto dto);
    
    DepartmentDto toDto(Department entity);
}
