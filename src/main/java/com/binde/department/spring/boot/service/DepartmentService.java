package com.binde.department.spring.boot.service;

import com.binde.department.spring.boot.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

   DepartmentDto getDepartmentById(Long id);
   List<DepartmentDto> getAllDepartment();
  DepartmentDto updateDepartment(Long id, DepartmentDto updateDepartment);
  void deleteDepartment(Long departmentId);
  DepartmentDto findDepartmentByAddress(DepartmentDto departmentAddress);
}
