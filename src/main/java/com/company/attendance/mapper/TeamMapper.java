package com.company.attendance.mapper;

import com.company.attendance.dto.TeamDto;
import com.company.attendance.entity.Team;
import com.company.attendance.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    
    @Mapping(target = "teamLeadId", source = "teamLead.id")
    @Mapping(target = "parentTeamId", source = "parentTeam.id")
    @Mapping(target = "memberIds", source = "members", qualifiedByName = "membersToMemberIds")
    @Mapping(target = "teamLeadName", source = "teamLead", qualifiedByName = "teamLeadToName")
    @Mapping(target = "memberCount", source = "members", qualifiedByName = "membersToCount")
    @Mapping(target = "parentTeamName", source = "parentTeam", qualifiedByName = "parentTeamToName")
    TeamDto toDto(Team team);
    
    @Mapping(target = "teamLead", ignore = true)
    @Mapping(target = "parentTeam", ignore = true)
    @Mapping(target = "members", ignore = true)
    @Mapping(target = "subTeams", ignore = true)
    @Mapping(target = "organization", ignore = true)
    Team toEntity(TeamDto dto);
    
    @Named("membersToMemberIds")
    default List<Long> membersToMemberIds(Set<Employee> members) {
        if (members == null) return null;
        return members.stream()
            .map(Employee::getId)
            .collect(Collectors.toList());
    }
    
    @Named("teamLeadToName")
    default String teamLeadToName(Employee teamLead) {
        if (teamLead == null) return null;
        return teamLead.getFirstName() + " " + teamLead.getLastName();
    }
    
    @Named("membersToCount")
    default Integer membersToCount(Set<Employee> members) {
        if (members == null) return 0;
        return members.size();
    }
    
    @Named("parentTeamToName")
    default String parentTeamToName(Team parentTeam) {
        if (parentTeam == null) return null;
        return parentTeam.getName();
    }
}

