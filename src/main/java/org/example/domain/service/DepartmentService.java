package org.example.domain.service;

import org.example.domain.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    void save(DepartmentDto departmentDto);
    DepartmentDto getById(Integer id);
    List<DepartmentDto> getAll();
    void delete(Integer id);
    void update(DepartmentDto departmentDto);
}
