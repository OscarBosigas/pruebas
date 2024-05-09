package org.example.domain.service.impl;

import org.example.domain.dto.LocationDto;
import org.example.domain.service.LocationService;
import org.example.persistence.entities.LocationEntity;
import org.example.persistence.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void save(LocationDto locationDto) {
        locationRepository.save(LocationEntity.builder()
                        .cantidad_oficinas(locationDto.getCantidad_oficinas())
                        .ciudad(locationDto.getCiudad())
                        .direccion(locationDto.getDireccion())
                        .id_locacion(locationDto.getId_locacion())
                .build());
    }

    @Override
    public LocationDto getById(Integer id) {
        LocationEntity locationEntity = locationRepository.getById(id);
        return LocationDto.builder()
                .cantidad_oficinas(locationEntity.getCantidad_oficinas())
                .ciudad(locationEntity.getCiudad())
                .direccion(locationEntity.getDireccion())
                .id_locacion(locationEntity.getId_locacion())
                .build();
    }

    @Override
    public List<LocationDto> getAll() {
        List<LocationDto> locationDtos = new ArrayList<>();
        List<LocationEntity> locationEntities = locationRepository.findAll();
        for(LocationEntity locationEntity: locationEntities){
            locationDtos.add(LocationDto.builder()
                            .id_locacion(locationEntity.getId_locacion())
                            .direccion(locationEntity.getDireccion())
                            .ciudad(locationEntity.getCiudad())
                            .cantidad_oficinas(locationEntity.getCantidad_oficinas())
                    .build());
        }
        return locationDtos;
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    @Override
    public void update(LocationDto locationDto) {
        locationRepository.save(LocationEntity.builder()
                .cantidad_oficinas(locationDto.getCantidad_oficinas())
                .ciudad(locationDto.getCiudad())
                .direccion(locationDto.getDireccion())
                .id_locacion(locationDto.getId_locacion())
                .build());
    }
}
