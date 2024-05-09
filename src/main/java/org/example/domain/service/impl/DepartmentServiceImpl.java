package org.example.domain.service.impl;

import org.example.domain.dto.DepartmentDto;
import org.example.domain.service.DepartmentService;
import org.example.persistence.entities.DepartmentEntity;
import org.example.persistence.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void save(DepartmentDto departmentDto) {
        departmentRepository.save(DepartmentEntity.builder()
                        .id_departamento(departmentDto.getId_departamento())
                        .id_locacion(departmentDto.getId_locacion())
                        .jefe(departmentDto.getJefe())
                        .nombre(departmentDto.getNombre())
                .build());
    }

    @Override
    public DepartmentDto getById(Integer id) {
        DepartmentEntity departmentEntity = departmentRepository.getById(id);
        return DepartmentDto.builder()
                .id_departamento(departmentEntity.getId_departamento())
                .id_locacion(departmentEntity.getId_locacion())
                .jefe(departmentEntity.getJefe())
                .nombre(departmentEntity.getNombre())
                .build();
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        for (DepartmentEntity departmentEntity:departmentEntities) {
            departmentDtos.add(DepartmentDto.builder()
                    .id_departamento(departmentEntity.getId_departamento())
                    .id_locacion(departmentEntity.getId_locacion())
                    .jefe(departmentEntity.getJefe())
                    .nombre(departmentEntity.getNombre())
                    .build());
        }
        return departmentDtos;
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void update(DepartmentDto departmentDto) {
        departmentRepository.save(DepartmentEntity.builder()
                .id_departamento(departmentDto.getId_departamento())
                .id_locacion(departmentDto.getId_locacion())
                .jefe(departmentDto.getJefe())
                .nombre(departmentDto.getNombre())
                .build());
    }
}
