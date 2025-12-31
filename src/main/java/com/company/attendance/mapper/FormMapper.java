package com.company.attendance.mapper;
import com.company.attendance.dto.FormDto;
import com.company.attendance.entity.Form;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface FormMapper {
    FormDto toDto(Form form);
    Form toEntity(FormDto dto);
}

