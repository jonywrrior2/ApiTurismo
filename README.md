API Turismo
La API Turismo proporciona endpoints para gestionar información sobre hoteles y clientes en un sistema de turismo.

Recursos Disponibles

Hoteles

Nombre: representa un hotel en el sistema.
Dirección: dirección física del hotel.
Estrellas: número de estrellas que tiene el hotel.
Descripción: descripción del hotel.
Año: año de fundación del hotel.
Fundador: nombre del fundador del hotel.
Precio: precio por noche en el hotel.
Metros Habitaciones: tamaño en metros cuadrados de las habitaciones del hotel.

Clientes

Nombre: nombre del cliente.
Apellido: apellido del cliente.
Email: correo electrónico del cliente.
Contraseña: contraseña del cliente.
Token: token de autenticación del cliente (Sería como el dni del cliente).

GET /hoteles/
Devuelve una lista de todos los hoteles disponibles.
GET /hoteles/?token=79662922O
[
"1,Hotel Maravilla,Av. de la Libertad, 123,4,Un lugar de ensueño con vistas al mar.,2005,Carlos Pérez,150.5,30.5",
"2,Gran Hotel Central,Calle Mayor, 67,5,Lujo y comodidad en el corazón de la ciudad.,1998,Marta González,250.75,40.2",
]

GET /hoteles/año/{anio}
Devuelve una lista de hoteles fundados en un año específico.
GET /hoteles/año/2003?token=79662922O
[
{
"id": 9,
"nombre": "Hotel Mediterráneo",
"direccion": "Paseo Marítimo, 15",
"estrellas": 3,
"descripcion": "Una experiencia mediterránea frente al mar.",
"anio": 2003,
"fundador": "Raúl Gómez",
"precio": 130.25,
"metroshabitaciones": 28.9
},
{
"id": 25,
"nombre": "Sunrise Hotel",
"direccion": "Av. del Amanecer, 10",
"estrellas": 3,
"descripcion": "Levántate con unas vistas espectaculares al amanecer.",
"anio": 2003,
"fundador": "Miguel García",
"precio": 145.0,
"metroshabitaciones": 31.5
},
{
"id": 52,
"nombre": "Hotel Luna de Valencia",
"direccion": "Plaza de la Luna, 15",
"estrellas": 3,
"descripcion": "Descubre la magia de Valencia en nuestro hotel.",
"anio": 2003,
"fundador": "Javier Fernández",
"precio": 150.25,
"metroshabitaciones": 30.8
}
]

GET /hoteles/direccion/{direccion}
Devuelve una lista de hoteles, los cuales la direccion contenga las letras o palabras en algun lugar de la dirección.
GET /hoteles/direccion/ma?token=79662922O
[
{
"id": 2,
"nombre": "Gran Hotel Central",
"direccion": "Calle Mayor, 67",
"estrellas": 5,
"descripcion": "Lujo y comodidad en el corazón de la ciudad.",
"anio": 1998,
"fundador": "Marta González",
"precio": 250.75,
"metroshabitaciones": 40.2
},
{
"id": 9,
"nombre": "Hotel Mediterráneo",
"direccion": "Paseo Marítimo, 15",
"estrellas": 3,
"descripcion": "Una experiencia mediterránea frente al mar.",
"anio": 2003,
"fundador": "Raúl Gómez",
"precio": 130.25,
"metroshabitaciones": 28.9
},
{
"id": 18,
"nombre": "Golden Sands Resort",
"direccion": "Playa Dorada, Av. del Mar",
"estrellas": 4,
"descripcion": "Vacaciones de ensueño en una de las mejores playas.",
"anio": 2011,
"fundador": "Juan Pérez",
"precio": 260.75,
"metroshabitaciones": 48.3
},
{
"id": 22,
"nombre": "Seaside Retreat",
"direccion": "Av. Marítima, 78",
"estrellas": 3,
"descripcion": "Una escapada junto al mar para recargar energías.",
"anio": 2007,
"fundador": "Roberto López",
"precio": 155.75,
"metroshabitaciones": 34.2
}
]

GET /hoteles/estrellas/{estrellas}
Devuelve una lista de hoteles con un número específico de estrellas.
/hoteles/estrellas/2?token=79662922O
[
{
"id": 86,
"nombre": "Hotel La Luna",
"direccion": "Calle de la Luna, 10",
"estrellas": 2,
"descripcion": "Un hotel sencillo pero acogedor en el corazón de la ciudad.",
"anio": 2006,
"fundador": "Pedro Martínez",
"precio": 90.0,
"metroshabitaciones": 20.0
},
{
"id": 87,
"nombre": "Hotel Los Pinos",
"direccion": "Avenida de los Pinos, 15",
"estrellas": 2,
"descripcion": "Un hotel económico rodeado de naturaleza y tranquilidad.",
"anio": 2003,
"fundador": "Laura Gómez",
"precio": 80.5,
"metroshabitaciones": 18.0
}
]

GET /hoteles/fundador/{fundador}
Devuelve una lista de hoteles fundados por un fundador específico.
/hoteles/fundador/Miguel García?token=45431248P
[
{
"id": 24,
"nombre": "Riverside Resort",
"direccion": "Calle del Río, 45",
"estrellas": 4,
"descripcion": "Vive la tranquilidad junto al río en nuestro resort.",
"anio": 2000,
"fundador": "Miguel García",
"precio": 195.25,
"metroshabitaciones": 37.3
},
{
"id": 25,
"nombre": "Sunrise Hotel",
"direccion": "Av. del Amanecer, 10",
"estrellas": 3,
"descripcion": "Levántate con unas vistas espectaculares al amanecer.",
"anio": 2003,
"fundador": "Miguel García",
"precio": 145.0,
"metroshabitaciones": 31.5
}
]

GET /hoteles/metrosMayores/{metros}
Devuelve una lista de hoteles con un tamaño de habitaciones mayor que un valor específico.
/hoteles/metrosMayores/60?token=45431248P
[
{
"id": 20,
"nombre": "Paradise Cove Resort",
"direccion": "Bahía Paraíso, Av. del Paraí",
"estrellas": 5,
"descripcion": "El paraíso te espera en nuestro exclusivo resort.",
"anio": 2016,
"fundador": "Pedro Fernández",
"precio": 400.0,
"metroshabitaciones": 65.0
},
{
"id": 40,
"nombre": "Seaside Paradise Resort",
"direccion": "Bahía Paraíso, Av. del Mar",
"estrellas": 5,
"descripcion": "El paraíso te espera en nuestro exclusivo resort frente al mar.",
"anio": 2010,
"fundador": "Lucía Martínez",
"precio": 390.0,
"metroshabitaciones": 63.0
},
{
"id": 42,
"nombre": "Tranquil Waters Resort",
"direccion": "Av. de las Aguas Tranquilas, 25",
"estrellas": 5,
"descripcion": "Sumérgete en la calma de nuestras aguas y relájate en nuestro lujoso resort.",
"anio": 2007,
"fundador": "Ana Gómez",
"precio": 410.75,
"metroshabitaciones": 68.2
}
]

GET /hoteles/metrosMenores/{metros}
Devuelve una lista de hoteles con un tamaño de habitaciones menor que un valor específico.
/hoteles/metrosMenores/20?token=45431248P
[
{
"id": 87,
"nombre": "Hotel Los Pinos",
"direccion": "Avenida de los Pinos, 15",
"estrellas": 2,
"descripcion": "Un hotel económico rodeado de naturaleza y tranquilidad.",
"anio": 2003,
"fundador": "Laura Gómez",
"precio": 80.5,
"metroshabitaciones": 18.0
},
{
"id": 91,
"nombre": "Hostal Estrella Solitaria",
"direccion": "Calle Estrella Solitaria, 5",
"estrellas": 1,
"descripcion": "Alojamiento económico para viajeros que buscan una estancia básica.",
"anio": 2000,
"fundador": "Laura Pérez",
"precio": 60.0,
"metroshabitaciones": 15.0
}
]

POST /hoteles/nuevoHotel
Permite agregar un nuevo hotel a la lista de hoteles disponibles.
/hoteles/nuevoHotel?token=45431248P
[
{
"id": 0,
"nombre": "prueba",
"direccion": "direccion",
"estrellas": 1,
"descripcion": "prueba inserccion",
"anio": 2002,
"fundador": "Cristian",
"precio": 70,
"metroshabitaciones": 50
}
]

GET /hoteles/precio/{precio}-{precio2}
Devuelve una lista de hoteles con un precio por noche en un rango específico.
/hoteles/precio/40-90?token=45431248P
[
{
"id": 86,
"nombre": "Hotel La Luna",
"direccion": "Calle de la Luna, 10",
"estrellas": 2,
"descripcion": "Un hotel sencillo pero acogedor en el corazón de la ciudad.",
"anio": 2006,
"fundador": "Pedro Martínez",
"precio": 90.0,
"metroshabitaciones": 20.0
},
{
"id": 87,
"nombre": "Hotel Los Pinos",
"direccion": "Avenida de los Pinos, 15",
"estrellas": 2,
"descripcion": "Un hotel económico rodeado de naturaleza y tranquilidad.",
"anio": 2003,
"fundador": "Laura Gómez",
"precio": 80.5,
"metroshabitaciones": 18.0
}
]

GET /hoteles/{id}
Devuelve información detallada sobre un hotel específico identificado por su ID.
/hoteles/5?token=45431248P
[
{
"id": 5,
"nombre": "Villa Serena",
"direccion": "Camino de la Tranquilidad",
"estrellas": 4,
"descripcion": "Un oasis de paz y serenidad en un entorno rural.",
"anio": 2008,
"fundador": "Daniel Ruiz",
"precio": 180.0,
"metroshabitaciones": 35.6
}
]

PUT /hoteles/{id}
Actualiza la información de un hotel existente identificado por su ID.
/hoteles/90?token=70504917A
[
{
"id": 90,
"nombre": "modificado",
"direccion": "calle clarinete",
"estrellas": 3,
"descripcion": "cambio con put",
"anio": 2013,
"fundador": "Pedro",
"precio": 80,
"metroshabitaciones": 60
}
]

DELETE /hoteles/{id}
Elimina un hotel existente identificado por su ID.
/hoteles/98?token=09775490V
[
{
"id": 98,
"nombre": "prueba",
"direccion": "direccion",
"estrellas": 1,
"descripcion": "prueba inserccion",
"anio": 2002,
"fundador": "Cristian",
"precio": 70.0,
"metroshabitaciones": 50.0
}
]