package com.company.attendance.mapper;

import com.company.attendance.dto.AnnouncementDto;
import com.company.attendance.entity.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    AnnouncementMapper INSTANCE = Mappers.getMapper(AnnouncementMapper.class);

    @Mapping(target = "organization", ignore = true)
    Announcement toEntity(AnnouncementDto dto);

    AnnouncementDto toDto(Announcement entity);

    @Mapping(target = "organization", ignore = true)
    void updateEntityFromDto(AnnouncementDto dto, @MappingTarget Announcement entity);
}
