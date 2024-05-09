package org.example.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "TRABAJOS")

public class JobsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trabajo")
    private Integer id_trabajo;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "salario")
    private Double salario;
    @Column(name = "id_departamento")
    private Integer id_departamento;
}
