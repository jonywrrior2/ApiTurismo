package com.example.apiturismo.repositories;

import com.example.apiturismo.pojos.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h.id as id, h.nombre as hotel, h.direccion as direccion, h.estrellas as estrellas, h.descripcion as descripcion, h.anio as anio ,h.fundador as fundador, h.precio as precio, h.metroshabitaciones as metrosHabitaciones FROM Hotel h")
    List<String> hoteles();

    Hotel getHotelById(Long id);

    List<Hotel> getHotelByFundador(String fundador);

    List<Hotel> getHotelByAnio(Integer anio);

    List <Hotel> getHotelByDireccionContainingIgnoreCase(String direccion);

    List<Hotel> getHotelByEstrellas(Integer estrellas);

    List<Hotel> getHotelByPrecioBetween(Double precio, Double precio2);

    List<Hotel> getHotelByMetroshabitacionesAfter(Double metros);

    List<Hotel> getHotelByMetroshabitacionesBefore(Double metros);

}
