package com.example.apiturismo.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String direccion;

    private Integer estrellas;

    private String descripcion;

    private Integer anio;

    private String fundador;

    private Double precio;

    private Double metroshabitaciones;




}
