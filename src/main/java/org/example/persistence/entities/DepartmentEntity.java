package org.example.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "DEPARTAMENTOS")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer id_departamento;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "jefe")
    private String jefe;
    @Column(name = "id_locacion")
    private Integer id_locacion;
}
