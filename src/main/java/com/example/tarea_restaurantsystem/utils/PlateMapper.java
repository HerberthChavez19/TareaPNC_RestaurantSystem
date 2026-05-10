package com.example.tarea_restaurantsystem.utils;

import com.example.tarea_restaurantsystem.DTO.request.PlateDTORequest;
import com.example.tarea_restaurantsystem.DTO.response.PlateDTOResponse;
import com.example.tarea_restaurantsystem.entity.Plate;

//En general el Plate Mapper, es el que nos permite tener una comunicacion entre los DTOs y las entidadades. Un traductor. Ademas que nos permite tener control en lo que le mostramos al cliente.

    //Recibe como entrada una request del cliente, que la transforma a una entidad. Para guardarlos en la base de datos.
public class PlateMapper {
    public static Plate toEntity(PlateDTORequest plateDTORequest) {
        return Plate.builder().name(plateDTORequest.plate_name())
                .description(plateDTORequest.plate_description())
                .build();
    }
    //Recibe la entidad, para posteriormente presentarle el resultado al cliente
    public static PlateDTOResponse toResponse(Plate plate){
        return new PlateDTOResponse(plate.getName(), plate.getPrice(), plate.getIsAvailable());
    }
}
