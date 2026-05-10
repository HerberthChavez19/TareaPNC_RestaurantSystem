package com.example.tarea_restaurantsystem.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder

//Es lo que el cliente recibe. Nos ayuda a tener un mayor control en lo que le mostramos al cliente.
public class GeneralResponse {
    Object data;
    String message;
}