package com.company.attendance.controller;
import com.company.attendance.dto.OrderDto;
import com.company.attendance.entity.Order;
import com.company.attendance.mapper.OrderMapper;
import com.company.attendance.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders() {
        var orders = orderService.findAll();
        var dtos = orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderMapper.toDto(orderService.getById(id)));
    }
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto dto) {
        Order order = orderService.save(orderMapper.toEntity(dto));
        return ResponseEntity.ok(orderMapper.toDto(order));
    }
    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto dto) {
        Order o = orderService.getById(id);
        Order saved = orderService.save(orderMapper.toEntity(dto));
        return ResponseEntity.ok(orderMapper.toDto(saved));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}

