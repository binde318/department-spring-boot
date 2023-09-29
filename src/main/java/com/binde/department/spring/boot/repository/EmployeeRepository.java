package com.binde.department.spring.boot.repository;

import com.binde.department.spring.boot.dto.EmployeeDto;
import com.binde.department.spring.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //EmployeeDto findEmployeesByEmployeeAddress(EmployeeDto dto);

    Employee findEmployeesByAddress(EmployeeDto employeeDto);
}
