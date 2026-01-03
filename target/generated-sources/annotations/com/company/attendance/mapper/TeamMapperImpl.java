package com.company.attendance.mapper;

import com.company.attendance.dto.TeamDto;
import com.company.attendance.entity.Employee;
import com.company.attendance.entity.Team;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-03T13:31:57+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Override
    public TeamDto toDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto.TeamDtoBuilder teamDto = TeamDto.builder();

        teamDto.teamLeadId( teamTeamLeadId( team ) );
        teamDto.parentTeamId( teamParentTeamId( team ) );
        teamDto.memberIds( membersToMemberIds( team.getMembers() ) );
        teamDto.teamLeadName( teamLeadToName( team.getTeamLead() ) );
        teamDto.memberCount( membersToCount( team.getMembers() ) );
        teamDto.parentTeamName( parentTeamToName( team.getParentTeam() ) );
        teamDto.id( team.getId() );
        teamDto.name( team.getName() );
        teamDto.description( team.getDescription() );
        teamDto.isActive( team.getIsActive() );
        teamDto.address( team.getAddress() );
        teamDto.city( team.getCity() );
        teamDto.state( team.getState() );
        teamDto.pincode( team.getPincode() );

        return teamDto.build();
    }

    @Override
    public Team toEntity(TeamDto dto) {
        if ( dto == null ) {
            return null;
        }

        Team.TeamBuilder team = Team.builder();

        team.id( dto.getId() );
        team.name( dto.getName() );
        team.address( dto.getAddress() );
        team.city( dto.getCity() );
        team.state( dto.getState() );
        team.pincode( dto.getPincode() );
        team.description( dto.getDescription() );
        team.isActive( dto.getIsActive() );

        return team.build();
    }

    private Long teamTeamLeadId(Team team) {
        if ( team == null ) {
            return null;
        }
        Employee teamLead = team.getTeamLead();
        if ( teamLead == null ) {
            return null;
        }
        Long id = teamLead.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long teamParentTeamId(Team team) {
        if ( team == null ) {
            return null;
        }
        Team parentTeam = team.getParentTeam();
        if ( parentTeam == null ) {
            return null;
        }
        Long id = parentTeam.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
