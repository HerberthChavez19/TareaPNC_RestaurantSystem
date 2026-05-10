package com.example.tarea_restaurantsystem.repository;

import com.example.tarea_restaurantsystem.entity.Plate;
//Este repositorio es una interfaz que extiende JpaRepository, lo que proporciona métodos CRUD para la entidad Plate sin necesidad de implementarlos manualmente. Spring Data JPA se encargará de generar las implementaciones necesarias en tiempo de ejecución.
//Springboot nos lo genera automaticamente, no tocamos queries.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//Este repository maneja la tabla Plate y su ID es tipo Long, por eso se especifica <Plate, Long>.
public interface PlateRepository extends JpaRepository<Plate, Long> {
    //El CRUD completo ya está implementado por JpaRepository, no es necesario agregar métodos adicionales a menos que se requieran consultas personalizadas.
}
