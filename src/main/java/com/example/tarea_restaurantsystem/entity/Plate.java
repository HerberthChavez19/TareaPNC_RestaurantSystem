package com.example.tarea_restaurantsystem.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity //Proviene de JPA, esta nos ayuda a decir que representa una tabla en la base de datos.
@Table(name = "Plate") //Tambien viene de JPA, nos permite darle un nombre a la tabla en la base de datos
@Data //Esta viene de Lombok, que nos ayuda a evitar repetir codigo. Genera setters and getters entre otros. RequiredArgsContructor?
@Builder //Usa el patron builder, que nos ayuda a crear objetos de manera mas practica.
@AllArgsConstructor //Genera un constructor en el que se le pasan todos los atributos de la clase.
@RequiredArgsConstructor

public class Plate {
    //Nos permite crear un ID autogenerado. Es creado por la bd, en vez de ser creado por el usuario/Java. En lugar de GenerationType.UUID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "plateName")
    private String name;
    @Column(name = "plateDescription")
    private String description;
    @Column(name = "platePrice")
    private double price;
    @Column(name = "plateIsAvailable")
    private Boolean isAvailable;
}
