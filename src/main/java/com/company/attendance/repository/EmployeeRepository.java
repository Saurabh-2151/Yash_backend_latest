package com.company.attendance.repository;

import com.company.attendance.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Employee> findByPhone(String phone);

    // Methods used by EmployeeService
    Optional<Employee> findByUserId(String userId);
    Optional<Employee> findByEmployeeId(String employeeId);
    List<Employee> findByStatus(Employee.Status status);
    boolean existsByUserId(String userId);
    boolean existsByEmployeeId(String employeeId);
}

