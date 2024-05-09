package org.example.domain.service.impl;

import org.example.domain.dto.JobsDto;
import org.example.domain.service.JobService;
import org.example.persistence.entities.JobsEntity;
import org.example.persistence.repositories.JobRepository;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void save(JobsDto jobsDto) throws PSQLException {
        JobsEntity jobsEntity = JobsEntity.builder()
                .id_departamento(jobsDto.getId_departamento())
                .id_trabajo(jobsDto.getId_trabajo())
                .salario(jobsDto.getSalario())
                .titulo(jobsDto.getTitulo())
                .build();
        jobRepository.save(jobsEntity);
    }

    @Override
    public List<JobsDto> getAll() {
        List<JobsDto> jobsDtos = new ArrayList<>();
        List<JobsEntity> jobsEntities = jobRepository.findAll();
        for (JobsEntity jobsEntity: jobsEntities) {
            jobsDtos.add(JobsDto.builder()
                    .id_departamento(jobsEntity.getId_departamento())
                    .id_trabajo(jobsEntity.getId_trabajo())
                    .salario(jobsEntity.getSalario())
                    .titulo(jobsEntity.getTitulo())
                    .build());
        }
        return jobsDtos;
    }

    @Override
    public JobsDto getById(int id) {
        JobsEntity jobsEntity = jobRepository.getById(id);
        return JobsDto.builder()
                .id_departamento(jobsEntity.getId_departamento())
                .id_trabajo(jobsEntity.getId_trabajo())
                .salario(jobsEntity.getSalario())
                .titulo(jobsEntity.getTitulo())
                .build();
    }

    @Override
    public void delete(int id) {
        jobRepository.deleteById(id);
    }

    @Override
    public void update(JobsDto jobsDto) {
        JobsEntity jobsEntity = JobsEntity.builder()
                .id_departamento(jobsDto.getId_departamento())
                .id_trabajo(jobsDto.getId_trabajo())
                .salario(jobsDto.getSalario())
                .titulo(jobsDto.getTitulo())
                .build();
        jobRepository.save(jobsEntity);
    }
}
