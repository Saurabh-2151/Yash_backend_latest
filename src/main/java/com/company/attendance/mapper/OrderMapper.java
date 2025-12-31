package com.company.attendance.mapper;
import com.company.attendance.dto.OrderDto;
import com.company.attendance.entity.Order;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order o);
    Order toEntity(OrderDto dto);
}

