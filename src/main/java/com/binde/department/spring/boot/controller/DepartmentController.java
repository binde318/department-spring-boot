package com.binde.department.spring.boot.controller;

import com.binde.department.spring.boot.dto.DepartmentDto;
import com.binde.department.spring.boot.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    //private final DepartmentRepository departmentRepository;
    @GetMapping("/address")
    public ResponseEntity<DepartmentDto>findDepartmentByAddress(@RequestParam("address") DepartmentDto departmentDto){
        DepartmentDto departmentDto1 = departmentService.findDepartmentByAddress(departmentDto);
        return ResponseEntity.ok(departmentDto1);
    }
    @PostMapping("/create-departments")
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto departmentDto1= departmentService.createDepartment(departmentDto);
    return new ResponseEntity<>(departmentDto1, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }
    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        List<DepartmentDto> departmentDtos = departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentDtos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable("id") Long departmentId,
                                                         @RequestBody DepartmentDto updateDepartment){
        DepartmentDto department = departmentService.updateDepartment(departmentId,updateDepartment);
        return ResponseEntity.ok(department);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }

}
