package com.example.tarea_restaurantsystem.DTO.response;

public record PlateDTOResponde(
        String plate_name,
        double price,
        Boolean isAvailable
) {
}
