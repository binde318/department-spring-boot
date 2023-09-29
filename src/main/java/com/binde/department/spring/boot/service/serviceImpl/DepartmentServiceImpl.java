package com.binde.department.spring.boot.service.serviceImpl;

import com.binde.department.spring.boot.dto.DepartmentDto;
import com.binde.department.spring.boot.entity.Department;
import com.binde.department.spring.boot.exception.ResourceNotFoundException;
import com.binde.department.spring.boot.mapper.DepartmentMapper;
import com.binde.department.spring.boot.repository.DepartmentRepository;
import com.binde.department.spring.boot.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapTodepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapTodepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("The department the given id does not exist :" + departmentId)
        );

        return DepartmentMapper.mapTodepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapTodepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updateDepartment) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with the given id " + departmentId)
        );
        department.setDepartmentName(updateDepartment.getDepartmentName());
        department.setDepartmentAddress(updateDepartment.getDepartmentAddress());
        department.setDepartmentDescription(updateDepartment.getDepartmentDescription());
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapTodepartmentDto(saveDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.findById(departmentId).orElseThrow(() ->
                new ResourceNotFoundException("Department is not exist with given id"+ departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentDto findDepartmentByAddress(DepartmentDto departmentAddress) {
        Department department = departmentRepository.findDepartmentByAddress(departmentAddress);
        return DepartmentMapper.mapTodepartmentDto(department);
    }


}
