package com.company.attendance.mapper;
import com.company.attendance.dto.LeaveRequestDto;
import com.company.attendance.entity.LeaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface LeaveRequestMapper {
    @Mapping(target = "employeeId", source = "employee.id")
    LeaveRequestDto toDto(LeaveRequest leaveRequest);
    LeaveRequest toEntity(LeaveRequestDto dto);
}

