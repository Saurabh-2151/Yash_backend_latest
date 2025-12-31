package com.company.attendance.mapper;

import com.company.attendance.dto.CaseDto;
import com.company.attendance.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaseMapper {
    
    CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);
    
    @Mapping(target = "clientName", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    CaseDto toDto(Case caseEntity);
    
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "documents", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    Case toEntity(CaseDto caseDto);
    
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "documents", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateEntityFromDto(CaseDto caseDto, @MappingTarget Case caseEntity);
    
    List<CaseDto> toDtoList(List<Case> cases);
    List<Case> toEntityList(List<CaseDto> caseDtos);
    
    @Named("getStatusString")
    default String getStatusString(Case.CaseStatus status) {
        return status != null ? status.name() : null;
    }
    
    @Named("getPriorityString")
    default String getPriorityString(Case.Priority priority) {
        return priority != null ? priority.name() : null;
    }
}
