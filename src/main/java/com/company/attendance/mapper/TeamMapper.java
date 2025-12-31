package com.company.attendance.mapper;

import com.company.attendance.dto.TeamDto;
import com.company.attendance.entity.Team;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamDto toDto(Team team);
    Team toEntity(TeamDto dto);
}

