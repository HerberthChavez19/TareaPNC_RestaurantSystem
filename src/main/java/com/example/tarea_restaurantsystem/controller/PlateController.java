package com.example.tarea_restaurantsystem.controller;

import com.example.tarea_restaurantsystem.DTO.GeneralResponse;
import com.example.tarea_restaurantsystem.DTO.request.PlateDTORequest;
import com.example.tarea_restaurantsystem.DTO.response.PlateDTOResponse;
import com.example.tarea_restaurantsystem.service.PlateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plates")
@AllArgsConstructor
public class PlateController {
    private final PlateService plateService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createPlate(@RequestBody PlateDTORequest plate) {
        plateService.createPlate(plate);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plate)
                .message("Plate has been created")
                .build());
    }

    @GetMapping()
    public ResponseEntity<GeneralResponse> findAll() {

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(plateService.findAllPlates())
                        .message("Plates retrieved successfully")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> findById(@PathVariable int id) {
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plateService.findPlateById((long) id))
                .message("Plate found with id: " + id)
                .build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updatePlate(@PathVariable Long id, @RequestBody PlateDTORequest plateRequest) {

        PlateDTOResponse updatedPlate = plateService.updatePlate(id, plateRequest);

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(updatedPlate)
                        .message("Plate updated successfully with id: " + id)
                        .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> delete(@PathVariable Long id) {
        // Aquí puedes implementar la lógica para eliminar un plato utilizando el PlateService

        plateService.deletePlateById(id);

        return ResponseEntity.ok(
                GeneralResponse.builder()
                        .data(null)
                        .message("Plate deleted successfully with id: " + id)
                        .build());
    }

}
