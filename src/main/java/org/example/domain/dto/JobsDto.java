package org.example.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class JobsDto {

        private Integer id_trabajo;
        private String titulo;
        private Double salario;
        private Integer id_departamento;

}
