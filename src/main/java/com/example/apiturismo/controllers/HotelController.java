package com.example.apiturismo.controllers;

import com.example.apiturismo.SecurityServices;
import com.example.apiturismo.pojos.Hotel;
import com.example.apiturismo.repositories.ClientRepository;
import com.example.apiturismo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoteles/")
public class HotelController {

    @Autowired
    private SecurityServices service;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping("")
    public ResponseEntity<List<String>> getAllHotels (@RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<String>>(hotelRepository.hoteles(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<String>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<Hotel>((Hotel) hotelRepository.getHotelById(id), HttpStatus.OK);
        }
        else
            return new ResponseEntity<Hotel>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/fundador/{fundador}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable String fundador, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            List<Hotel> hoteles = hotelRepository.getHotelByFundador(fundador);
            return new ResponseEntity<>(hoteles, HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("año/{anio}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable Integer anio, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByAnio(anio), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("direccion/{direccion}")
    public ResponseEntity<List<Hotel>> getHotelByDireccion(@PathVariable String direccion, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByDireccionContainingIgnoreCase(direccion), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping ("estrellas/{estrellas}")
    public ResponseEntity<List<Hotel>> getHotelByEstrellas(@PathVariable Integer estrellas, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByEstrellas(estrellas), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping ("precio/{precio}-{precio2}")
    public ResponseEntity<List<Hotel>> getHotelByPrecioBetween(@PathVariable Double precio,@PathVariable Double precio2, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByPrecioBetween(precio, precio2), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping ("metrosMenores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosBefore(@PathVariable Double metros, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesBefore(metros), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping ("metrosMayores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosAfter(@PathVariable Double metros, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesAfter(metros), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

@PostMapping("/nuevoHotel")
public ResponseEntity <Hotel> nuevoHotel(@RequestBody Hotel hotel,@RequestParam String token) {
    if(service.validateTokerForUsers(token)) {
        return new ResponseEntity<>(hotelRepository.save(hotel),HttpStatus.OK);
    }
    else
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> put(@PathVariable Long id, @RequestBody Hotel hotelNuevo, @RequestParam String token) {
        if( !service.validateTokerForUsers(token) ){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {

            var hotel = new Hotel();
            var optionalHotel = hotelRepository.findById(id);

            if (optionalHotel.isEmpty()){
                hotel=hotelNuevo;
            }
            else {
                hotel = optionalHotel.get();
                hotel.setNombre(hotelNuevo.getNombre());
                hotel.setAnio(hotelNuevo.getAnio());
                hotel.setDescripcion(hotelNuevo.getDescripcion());
                hotel.setFundador(hotelNuevo.getFundador());
                hotel.setEstrellas(hotelNuevo.getEstrellas());
                hotel.setDireccion(hotelNuevo.getDireccion());
                hotel.setPrecio(hotelNuevo.getPrecio());
                hotel.setMetroshabitaciones(hotelNuevo.getMetroshabitaciones());
            }

            return new ResponseEntity<Hotel>(hotelRepository.save(hotel),HttpStatus.OK);
        }

    }

    @DeleteMapping("/{id}")
    /**
     * Elimina un hotel
     */
    public ResponseEntity<Hotel> delete(@PathVariable Long id, @RequestParam String token){
        ResponseEntity<Hotel> respuesta = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        if(service.validateTokerForUsers(token)){
        Hotel salida = new Hotel();
        if(hotelRepository.existsById(id)){
            salida =hotelRepository.findById(id).get();
            hotelRepository.deleteById(id);
            respuesta = new ResponseEntity<Hotel>(salida, HttpStatus.OK);
        } else
            respuesta = new ResponseEntity<Hotel>(salida, HttpStatus.NOT_FOUND);
        }
        return respuesta;
    }

}


