package com.binde.department.spring.boot.service;

import com.binde.department.spring.boot.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);
    EmployeeDto findEmployeeByAddress(EmployeeDto employeeAddress);
}

