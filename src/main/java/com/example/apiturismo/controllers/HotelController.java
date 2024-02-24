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

/**
 * Controlador REST para la gestión de hoteles.
 */
@RestController
@RequestMapping("/hoteles/")
public class HotelController {

    @Autowired
    private SecurityServices service;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Obtiene todos los hoteles.
     *
     * @param token El token de autenticación del usuario.
     * @return ResponseEntity con una lista de nombres de hoteles y el código de estado correspondiente.
     */
    @GetMapping("")
    public ResponseEntity<List<String>> getAllHotels (@RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<String>>(hotelRepository.hoteles(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<String>>(HttpStatus.UNAUTHORIZED);
    }
    /**
     * Obtiene un hotel por su ID.
     *
     * @param id    El ID del hotel.
     * @param token El token de autenticación del usuario.
     * @return ResponseEntity con el hotel encontrado y el código de estado correspondiente.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<Hotel>((Hotel) hotelRepository.getHotelById(id), HttpStatus.OK);
        }
        else
            return new ResponseEntity<Hotel>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles por el nombre del fundador.
     *
     * @param fundador El nombre del fundador del hotel.
     * @param token    El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping("/fundador/{fundador}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable String fundador, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            List<Hotel> hoteles = hotelRepository.getHotelByFundador(fundador);
            return new ResponseEntity<>(hoteles, HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles por el año de fundación.
     *
     * @param anio  El año de fundación del hotel.
     * @param token El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping("año/{anio}")
    public ResponseEntity<List<Hotel>> getHotelByFundador(@PathVariable Integer anio, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByAnio(anio), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles por dirección.
     *
     * @param direccion La dirección del hotel.
     * @param token     El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping("direccion/{direccion}")
    public ResponseEntity<List<Hotel>> getHotelByDireccion(@PathVariable String direccion, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByDireccionContainingIgnoreCase(direccion), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles por número de estrellas.
     *
     * @param estrellas El número de estrellas del hotel.
     * @param token     El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping ("estrellas/{estrellas}")
    public ResponseEntity<List<Hotel>> getHotelByEstrellas(@PathVariable Integer estrellas, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByEstrellas(estrellas), HttpStatus.OK);
        }
        else
            return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }
    /**
     * Obtiene una lista de hoteles por rango de precios.
     *
     * @param precio  El precio mínimo del rango.
     * @param precio2 El precio máximo del rango.
     * @param token   El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */

    @GetMapping ("precio/{precio}-{precio2}")
    public ResponseEntity<List<Hotel>> getHotelByPrecioBetween(@PathVariable Double precio,@PathVariable Double precio2, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByPrecioBetween(precio, precio2), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles con un número de metros cuadrados de habitaciones menor a un valor dado.
     *
     * @param metros El número de metros cuadrados.
     * @param token  El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping ("metrosMenores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosBefore(@PathVariable Double metros, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesBefore(metros), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Obtiene una lista de hoteles con un número de metros cuadrados de habitaciones mayor a un valor dado.
     *
     * @param metros El número de metros cuadrados.
     * @param token  El token de autenticación del usuario.
     * @return ResponseEntity con una lista de hoteles encontrados y el código de estado correspondiente.
     */
    @GetMapping ("metrosMayores/{metros}")
    public ResponseEntity<List<Hotel>> getHotelByMetrosAfter(@PathVariable Double metros, @RequestParam String token){
        if (service.validateTokerForUsers(token)) {
            return new ResponseEntity<List<Hotel>>(hotelRepository.getHotelByMetroshabitacionesAfter(metros), HttpStatus.OK);
        }
        return new ResponseEntity<List<Hotel>>(HttpStatus.UNAUTHORIZED);
    }
    /**
     * Crea un nuevo hotel.
     *
     * @param hotel El objeto Hotel a ser creado.
     * @param token El token de autenticación del usuario.
     * @return ResponseEntity con el hotel creado y el código de estado correspondiente.
     */
@PostMapping("/nuevoHotel")
public ResponseEntity <Hotel> nuevoHotel(@RequestBody Hotel hotel,@RequestParam String token) {
    if(service.validateTokerForUsers(token)) {
        return new ResponseEntity<>(hotelRepository.save(hotel),HttpStatus.OK);
    }
    else
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    /**
     * Actualiza un hotel existente.
     *
     * @param id         El ID del hotel a actualizar.
     * @param hotelNuevo El objeto Hotel con los nuevos datos.
     * @param token      El token de autenticación del usuario.
     * @return ResponseEntity con el hotel actualizado y el código de estado correspondiente.
     */

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

    /**
     * Elimina un hotel por su ID.
     *
     * @param id    El ID del hotel a eliminar.
     * @param token El token de autenticación del usuario.
     * @return ResponseEntity con el hotel eliminado y el código de estado correspondiente.
     */
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


