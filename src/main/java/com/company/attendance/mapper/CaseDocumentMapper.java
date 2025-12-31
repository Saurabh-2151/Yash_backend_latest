package com.company.attendance.mapper;

import com.company.attendance.dto.CaseDocumentDto;
import com.company.attendance.entity.CaseDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaseDocumentMapper {
    
    CaseDocumentMapper INSTANCE = Mappers.getMapper(CaseDocumentMapper.class);
    
    @Mapping(target = "caseNumber", ignore = true)
    @Mapping(target = "file", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    CaseDocumentDto toDto(CaseDocument document);
    
    @Mapping(target = "caseEntity", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    CaseDocument toEntity(CaseDocumentDto documentDto);
    
    @Mapping(target = "caseEntity", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    void updateEntityFromDto(CaseDocumentDto documentDto, @MappingTarget CaseDocument document);
    
    List<CaseDocumentDto> toDtoList(List<CaseDocument> documents);
    List<CaseDocument> toEntityList(List<CaseDocumentDto> documentDtos);
}
