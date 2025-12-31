package com.company.attendance.service;

import com.company.attendance.entity.Team;
import com.company.attendance.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Team save(Team team) { return teamRepository.save(team); }
    public List<Team> findAll() { return teamRepository.findAll(); }
    public Team getById(Long id) { return teamRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { teamRepository.deleteById(id); }
}

