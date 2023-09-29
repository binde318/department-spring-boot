package com.binde.department.spring.boot.mapper;

import com.binde.department.spring.boot.dto.EmployeeDto;
import com.binde.department.spring.boot.entity.Employee;

public class EmployeeMapper {

    //covert employee jpa entity to employee dto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(employee.getId(),
                employee.getEmployeeName(),
                employee.getEmployeeEmail(),
                employee.getEmployeeAddress(),
                employee.getEmployeePosition()

        );
    }
    //convert employeedto to jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getEmployeeName(),
                employeeDto.getEmployeeEmail(),
                employeeDto.getEmployeeAddress(),
                employeeDto.getEmployeePosition()
        );
    }
}
