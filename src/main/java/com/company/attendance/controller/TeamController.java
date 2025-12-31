package com.company.attendance.controller;

import com.company.attendance.dto.TeamDto;
import com.company.attendance.entity.Team;
import com.company.attendance.mapper.TeamMapper;
import com.company.attendance.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    private final TeamMapper teamMapper;

    @GetMapping
    public ResponseEntity<List<TeamDto>> listTeams() {
        var teams = teamService.findAll();
        var dtos = teams.stream().map(teamMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long id) {
        return ResponseEntity.ok(teamMapper.toDto(teamService.getById(id)));
    }

    @PostMapping
    public ResponseEntity<TeamDto> createTeam(@Valid @RequestBody TeamDto dto) {
        Team team = teamService.save(teamMapper.toEntity(dto));
        return ResponseEntity.ok(teamMapper.toDto(team));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@PathVariable Long id, @RequestBody TeamDto dto) {
        Team t = teamService.getById(id);
        Team saved = teamService.save(teamMapper.toEntity(dto));
        return ResponseEntity.ok(teamMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.ok().build();
    }
}

