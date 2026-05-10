package com.example.tarea_restaurantsystem.DTO.response;

public record PlateDTOResponse(
        String plate_name,
        double price,
        Boolean isAvailable
) {
}
