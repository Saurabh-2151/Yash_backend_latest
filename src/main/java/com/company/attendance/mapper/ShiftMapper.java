package com.company.attendance.mapper;

import com.company.attendance.dto.ShiftDto;
import com.company.attendance.entity.Shift;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShiftMapper {
    ShiftMapper INSTANCE = Mappers.getMapper(ShiftMapper.class);

    @Mapping(target = "organization", ignore = true)
    @Mapping(target = "employees", ignore = true)
    Shift toEntity(ShiftDto dto);
    
    ShiftDto toDto(Shift entity);
    
    List<ShiftDto> toDtoList(List<Shift> entities);
}
