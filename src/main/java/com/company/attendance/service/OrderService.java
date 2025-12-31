package com.company.attendance.service;
import com.company.attendance.entity.Order;
import com.company.attendance.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Order save(Order order) { return orderRepository.save(order); }
    public List<Order> findAll() { return orderRepository.findAll(); }
    public Order getById(Long id) { return orderRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { orderRepository.deleteById(id); }
}

