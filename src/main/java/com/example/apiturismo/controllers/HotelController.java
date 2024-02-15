package com.example.apiturismo.controllers;

import com.example.apiturismo.pojos.Hotel;
import com.example.apiturismo.repositories.ClientRepository;
import com.example.apiturismo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hoteles/")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;


    @GetMapping("")
    public ResponseEntity<List<String>> getAllHotels (){
        return new ResponseEntity<List<String>>(hotelRepository.hoteles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return new ResponseEntity<Hotel>((Hotel) hotelRepository.getHotelById(id), HttpStatus.OK);
    }

    @GetMapping("/fundador/{fundador}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable String fundador){
        List<Hotel> hoteles = hotelRepository.getHotelByFundador(fundador);
        return new ResponseEntity<>(hoteles, HttpStatus.OK);
    }

    @GetMapping("año/{anio}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable Integer anio){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByAnio(anio), HttpStatus.OK);
    }

    @GetMapping("direccion/{direccion}")
    public ResponseEntity<List<Hotel>> getHotelByDireccion(@PathVariable String direccion){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByDireccionContainingIgnoreCase(direccion), HttpStatus.OK);
    }

    @GetMapping ("estrellas/{estrellas}")
    public ResponseEntity<List<Hotel>> getHotelByEstrellas(@PathVariable Integer estrellas){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByEstrellas(estrellas), HttpStatus.OK);
    }

    @GetMapping ("precio/{precio}-{precio2}")
    public ResponseEntity<List<Hotel>> getHotelByPrecioBetween(@PathVariable Double precio,@PathVariable Double precio2){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByPrecioBetween(precio,precio2), HttpStatus.OK);
    }

    @GetMapping ("metrosMenores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosBefore(@PathVariable Double metros){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesBefore(metros), HttpStatus.OK);
    }

    @GetMapping ("metrosMayores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosAfter(@PathVariable Double metros){
        return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesAfter(metros), HttpStatus.OK);
    }
}
