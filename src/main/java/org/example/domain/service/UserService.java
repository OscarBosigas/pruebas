package org.example.domain.service;

import org.example.domain.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);
    List<UserDto> getAll();
    UserDto getById(int id);
    void delete(int id);
    void update(UserDto userDto);
}
