package com.company.attendance.service;
import com.company.attendance.entity.LeaveRequest;
import com.company.attendance.repository.LeaveRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;
    public LeaveRequest save(LeaveRequest leave) { return leaveRequestRepository.save(leave); }
    public List<LeaveRequest> findAll() { return leaveRequestRepository.findAll(); }
    public LeaveRequest getById(Long id) { return leaveRequestRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { leaveRequestRepository.deleteById(id); }
}
