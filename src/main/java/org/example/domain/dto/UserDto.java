package org.example.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {

    private Integer id_usuario;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer id_trabajo;
}
