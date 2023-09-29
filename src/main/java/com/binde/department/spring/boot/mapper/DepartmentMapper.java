package com.binde.department.spring.boot.mapper;

import com.binde.department.spring.boot.dto.DepartmentDto;
import com.binde.department.spring.boot.entity.Department;

public class DepartmentMapper {
    //convert department jpa entity to department dto
    public static DepartmentDto mapTodepartmentDto(Department department){
        return new DepartmentDto(department.getId(),
                department.getDepartmentName(),
                department.getDepartmentEmail(),
                department.getDepartmentAddress(),
                department.getDepartmentDescription());

    }
    //convert department dto in to jpa entity
    public static Department mapTodepartment(DepartmentDto departmentDto){
        return new Department(departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentEmail(),
                departmentDto.getDepartmentAddress(),
                departmentDto.getDepartmentDescription());
    }
}
