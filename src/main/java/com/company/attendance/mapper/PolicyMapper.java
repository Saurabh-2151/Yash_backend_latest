package com.company.attendance.mapper;

import com.company.attendance.dto.PolicyDto;
import com.company.attendance.entity.Policy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PolicyMapper {
    PolicyMapper INSTANCE = Mappers.getMapper(PolicyMapper.class);

    @Mapping(target = "organization", ignore = true)
    Policy toEntity(PolicyDto dto);
    
    PolicyDto toDto(Policy entity);
}
