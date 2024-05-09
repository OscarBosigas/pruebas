package org.example.domain.service.impl;

import org.example.domain.dto.UserDto;
import org.example.domain.service.UserService;
import org.example.persistence.entities.UserEntity;
import org.example.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .id_usuario(userDto.getId_usuario())
                .nombre(userDto.getNombre())
                .apellido(userDto.getApellido())
                .edad(userDto.getEdad())
                .id_trabajo(userDto.getId_trabajo())
                        .build();
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> datos = new ArrayList<>();
        List<UserEntity> entityList = userRepository.findAll();
        for (UserEntity userEntity: entityList) {
            UserDto userDto = UserDto.builder()
                    .id_usuario(userEntity.getId_usuario())
                    .apellido(userEntity.getApellido())
                    .edad(userEntity.getEdad())
                    .nombre(userEntity.getNombre())
                    .id_trabajo(userEntity.getId_trabajo())
                    .build();
            datos.add(userDto);
        }
        return datos;
    }

    @Override
    public UserDto getById(int id) {
        UserEntity userEntity = userRepository.getById(id);
        return UserDto.builder()
                .id_trabajo(userEntity.getId_trabajo())
                .nombre(userEntity.getNombre())
                .edad(userEntity.getEdad())
                .apellido(userEntity.getApellido())
                .id_usuario(userEntity.getId_usuario())
                .build();
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .id_usuario(userDto.getId_usuario())
                .nombre(userDto.getNombre())
                .apellido(userDto.getApellido())
                .edad(userDto.getEdad())
                .id_trabajo(userDto.getId_trabajo())
                .build();
        userRepository.save(userEntity);
    }

}
