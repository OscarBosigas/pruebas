package org.example.domain.service;

import org.example.domain.dto.JobsDto;
import java.util.List;

public interface JobService {

    void save(JobsDto jobsDto);
    List<JobsDto> getAll();
    JobsDto getById(int id);
    void delete(int id);
    void update(JobsDto jobsDto);
}
