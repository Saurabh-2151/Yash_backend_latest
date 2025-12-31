package com.company.attendance.service;
import com.company.attendance.entity.Expense;
import com.company.attendance.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public Expense save(Expense expense) { return expenseRepository.save(expense); }
    public List<Expense> findAll() { return expenseRepository.findAll(); }
    public Expense getById(Long id) { return expenseRepository.findById(id).orElseThrow(); }
    public void delete(Long id) { expenseRepository.deleteById(id); }
}

