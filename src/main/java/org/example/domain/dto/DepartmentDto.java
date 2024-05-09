package org.example.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DepartmentDto {

    private Integer id_departamento;
    private String nombre;
    private String jefe;
    private Integer id_locacion;
}
