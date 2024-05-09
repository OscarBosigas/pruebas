package org.example.domain.service;

import org.example.domain.dto.JobsDto;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface JobService {

    void save(JobsDto jobsDto) throws PSQLException;
    List<JobsDto> getAll();
    JobsDto getById(int id);
    void delete(int id);
    void update(JobsDto jobsDto);
}
