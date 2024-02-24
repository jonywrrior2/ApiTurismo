package com.example.apiturismo.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un hotel en el sistema de turismo.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    /**
     * Identificador único del hotel.
     */

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del hotel.
     */

    private String nombre;

    /**
     * Dirección del hotel.
     */

    private String direccion;

    /**
     * Número de estrellas del hotel.
     */

    private Integer estrellas;

    /**
     * Descripción del hotel.
     */

    private String descripcion;

    /**
     * Año de fundación del hotel.
     */

    private Integer anio;

    /**
     * Nombre del fundador del hotel.
     */

    private String fundador;

    /**
     * Precio por noche en el hotel.
     */

    private Double precio;

    /**
     * Metros cuadrados de habitaciones en el hotel.
     */

    private Double metroshabitaciones;




}
