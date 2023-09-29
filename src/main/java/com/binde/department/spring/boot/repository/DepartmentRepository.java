package com.binde.department.spring.boot.repository;

import com.binde.department.spring.boot.dto.DepartmentDto;
import com.binde.department.spring.boot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
   //Department findDepartmentByDepartmentAddress(DepartmentDto departmentAddress);
   Department findDepartmentByAddress(DepartmentDto departmentAddress);
}
