package org.example.persistence.repositories;

import org.example.persistence.entities.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobsEntity, Integer> {
}
