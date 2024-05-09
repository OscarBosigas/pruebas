package org.example.domain.service;

import org.example.domain.dto.LocationDto;

import java.util.List;

public interface LocationService {

    void save(LocationDto locationDto);
    LocationDto getById(Integer id);
    List<LocationDto> getAll();
    void delete(Integer id);

    void update(LocationDto locationDto);
}
