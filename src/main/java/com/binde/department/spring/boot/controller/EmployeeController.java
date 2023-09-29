package com.binde.department.spring.boot.controller;

import com.binde.department.spring.boot.dto.EmployeeDto;
import com.binde.department.spring.boot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @PostMapping("/create-employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }
    @GetMapping("/address")
    public ResponseEntity<EmployeeDto> findEmployeeByAddress(@PathVariable("address") EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.findEmployeeByAddress(employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }



    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employeeDtos =employeeService.getAllEmployee();
        return ResponseEntity.ok(employeeDtos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(employeeId, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee has been deleted successfully!");
    }
}
