package com.example.apiturismo.repositories;

import com.example.apiturismo.pojos.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interfaz que define un repositorio para la entidad Hotel en el sistema de turismo.
 * Extiende JpaRepository para obtener métodos básicos.
 */
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Obtiene una lista de nombres de todos los hoteles.
     *
     * @return Lista de nombres de hoteles.
     */

    @Query("SELECT h.id as id, h.nombre as hotel, h.direccion as direccion, h.estrellas as estrellas, h.descripcion as descripcion, h.anio as anio ,h.fundador as fundador, h.precio as precio, h.metroshabitaciones as metrosHabitaciones FROM Hotel h")
    List<String> hoteles();

    /**
     * Obtiene un hotel por su ID.
     *
     * @param id El ID del hotel.
     * @return El hotel correspondiente al ID dado.
     */
    Hotel getHotelById(Long id);

    /**
     * Obtiene una lista de hoteles por el nombre del fundador.
     *
     * @param fundador El nombre del fundador del hotel.
     * @return Lista de hoteles fundados por el fundador dado.
     */
    List<Hotel> getHotelByFundador(String fundador);

    /**
     * Obtiene una lista de hoteles por el año de fundación.
     *
     * @param anio El año de fundación del hotel.
     * @return Lista de hoteles fundados en el año dado.
     */
    List<Hotel> getHotelByAnio(Integer anio);

    /**
     * Obtiene una lista de hoteles por dirección, ignorando mayúsculas y minúsculas.
     *
     * @param direccion La dirección del hotel.
     * @return Lista de hoteles con la dirección dada.
     */
    List <Hotel> getHotelByDireccionContainingIgnoreCase(String direccion);

    /**
     * Obtiene una lista de hoteles por número de estrellas.
     *
     * @param estrellas El número de estrellas del hotel.
     * @return Lista de hoteles con el número de estrellas dado.
     */
    List<Hotel> getHotelByEstrellas(Integer estrellas);

    /**
     * Obtiene una lista de hoteles con un precio entre los valores dados.
     *
     * @param precio  El precio mínimo.
     * @param precio2 El precio máximo.
     * @return Lista de hoteles con precios dentro del rango dado.
     */
    List<Hotel> getHotelByPrecioBetween(Double precio, Double precio2);

    /**
     * Obtiene una lista de hoteles con un número de metros cuadrados de habitaciones mayor a un valor dado.
     *
     * @param metros El número de metros cuadrados.
     * @return Lista de hoteles con metros cuadrados de habitaciones mayores al valor dado.
     */
    List<Hotel> getHotelByMetroshabitacionesAfter(Double metros);

    /**
     * Obtiene una lista de hoteles con un número de metros cuadrados de habitaciones menor a un valor dado.
     *
     * @param metros El número de metros cuadrados.
     * @return Lista de hoteles con metros cuadrados de habitaciones menores al valor dado.
     */
    List<Hotel> getHotelByMetroshabitacionesBefore(Double metros);

}
