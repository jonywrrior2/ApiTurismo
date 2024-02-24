package com.example.apiturismo.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa un cliente en el sistema de turismo.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    /**
     * Identificador único del cliente.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del cliente.
     */

    private String nombre;

    /**
     * Apellido del cliente.
     */

    private String apellido;

    /**
     * Correo electrónico del cliente. Este campo se omite en la serialización/deserialización JSON.
     */

    @JsonIgnore
    private String email;

    /**
     * Contraseña del cliente. Este campo se omite en la serialización/deserialización JSON.
     */

    @JsonIgnore
    private String contrasenha;

    /**
     * Token de autenticación del cliente. Este campo se omite en la serialización/deserialización JSON.
     */

    @JsonIgnore
    private String token;

    
}
