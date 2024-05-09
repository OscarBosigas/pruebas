package org.example.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class LocationDto {

    private Integer id_locacion;
    private String ciudad;
    private String direccion;
    private Integer cantidad_oficinas;
}
