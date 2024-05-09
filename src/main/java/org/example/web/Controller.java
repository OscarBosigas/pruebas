package org.example.web;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.example.domain.dto.DepartmentDto;
import org.example.domain.dto.JobsDto;
import org.example.domain.dto.LocationDto;
import org.example.domain.dto.UserDto;
import org.example.domain.service.impl.DepartmentServiceImpl;
import org.example.domain.service.impl.JobServiceImpl;
import org.example.domain.service.impl.LocationServiceImpl;
import org.example.domain.service.impl.UserServiceImpl;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/")
@AllArgsConstructor
@CrossOrigin(value = "*")
public class Controller {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private JobServiceImpl jobService;

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Autowired
    private LocationServiceImpl locationService;

    @GetMapping("usuarios")
    public ResponseEntity<List<UserDto>> allUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
    }

    @GetMapping("usuario")
    public ResponseEntity<UserDto> getUsuario(@RequestParam Integer id_usuario){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id_usuario));
    }

    @PostMapping("usuario")
    public ResponseEntity<Object> crearUsuario(@RequestBody UserDto userDto){
        userService.save(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("usuario")
    public ResponseEntity eliminarUsuario(@RequestParam Integer id_usuario){
        userService.delete(id_usuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("usuario")
    public ResponseEntity actualizarUsuario(@RequestBody UserDto userDto){
        userService.update(userDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("trabajo")
    public ResponseEntity crearTrabajo(@RequestBody JobsDto jobsDto) throws PSQLException {
        jobService.save(jobsDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("trabajos")
    public ResponseEntity<List<JobsDto>> trabajos(){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getAll());
    }

    @GetMapping("trabajo")
    public ResponseEntity<JobsDto> job(@RequestParam Integer id_trabajo){
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getById(id_trabajo));
    }

    @DeleteMapping("trabajo")
    public ResponseEntity eliminarJob(@RequestParam Integer id_trabajo){
        jobService.delete(id_trabajo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("trabajo")
    public ResponseEntity actualizarJob(@RequestBody JobsDto jobsDto){
        jobService.update(jobsDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("departamento")
    public ResponseEntity crearDpto(@RequestBody DepartmentDto departmentDto){
        departmentService.save(departmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("departamentos")
    public ResponseEntity<List<DepartmentDto>> dptos(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAll());
    }

    @GetMapping("departamento")
    public ResponseEntity<DepartmentDto> dpto(@RequestParam Integer id_departamento){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.getById(id_departamento));
    }

    @DeleteMapping("departamento")
    public ResponseEntity eliminarDpto(@RequestParam Integer id_departamento){
        departmentService.delete(id_departamento);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("departamento")
    public ResponseEntity actualizarDpto(@RequestBody DepartmentDto departmentDto){
        departmentService.update(departmentDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("locacion")
    public  ResponseEntity crearLoca(@RequestBody LocationDto locationDto){
        locationService.save(locationDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("locaciones")
    public  ResponseEntity<List<LocationDto>> locaciones(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getAll());
    }

    @GetMapping("locacion")
    public ResponseEntity<LocationDto> locacion(@RequestParam Integer id_locacion){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getById(id_locacion));
    }

    @PutMapping("locacion")
    public ResponseEntity actualizarLocacion(@RequestParam LocationDto locationDto){
        locationService.update(locationDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("locacion")
    public ResponseEntity eliminarLocacion(@RequestParam Integer id_locacion){
        locationService.delete(id_locacion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
