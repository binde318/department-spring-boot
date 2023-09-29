package com.binde.department.spring.boot.service.serviceImpl;

import com.binde.department.spring.boot.dto.EmployeeDto;
import com.binde.department.spring.boot.entity.Employee;
import com.binde.department.spring.boot.exception.ResourceNotFoundException;
import com.binde.department.spring.boot.mapper.EmployeeMapper;
import com.binde.department.spring.boot.repository.EmployeeRepository;
import com.binde.department.spring.boot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return  employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow( () ->
                new ResourceNotFoundException("The employee with the id does not exist" + employeeId)
        );
       employee.setEmployeeName(employeeDto.getEmployeeName());
       employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
       employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
       employee.setEmployeePosition(employeeDto.getEmployeePosition());
       Employee saveEmployee = employeeRepository.save(employee);


       return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Department is not exist with given id"+ employeeId)
        );
        employeeRepository.deleteById(employeeId);

    }

    @Override
    public EmployeeDto findEmployeeByAddress(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findEmployeesByAddress(employeeDto);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }



}
