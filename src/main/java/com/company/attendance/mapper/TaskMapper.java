package com.company.attendance.mapper;
import com.company.attendance.dto.TaskDto;
import com.company.attendance.entity.Task;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    Task toEntity(TaskDto dto);
}

