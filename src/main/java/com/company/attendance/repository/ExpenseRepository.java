package com.company.attendance.repository;
import com.company.attendance.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {}

