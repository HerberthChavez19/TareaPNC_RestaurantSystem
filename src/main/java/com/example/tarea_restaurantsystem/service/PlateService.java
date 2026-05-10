package com.example.tarea_restaurantsystem.service;

import com.example.tarea_restaurantsystem.DTO.request.PlateDTORequest;
import com.example.tarea_restaurantsystem.DTO.response.PlateDTOResponse;
import com.example.tarea_restaurantsystem.entity.Plate;
import com.example.tarea_restaurantsystem.repository.PlateRepository;
import com.example.tarea_restaurantsystem.utils.PlateMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlateService {

    private PlateRepository plateRepository;

    public void createPlate(PlateDTORequest plate) {
        // Lógica para crear un nuevo plato utilizando el PlateRepository
        plateRepository.save(PlateMapper.toEntity(plate));
    }

    public List<PlateDTOResponse> findAllPlates() {
        return plateRepository.findAll()
                .stream()
                .map(PlateMapper::toResponse)
                .toList();
    }

    //Ocupamos este porque podemos tener un mayor control al momento de hacer las request. Por ejemplo, nos avisa si el id no existe.
    public PlateDTOResponse findPlateById(Long id) {
        return plateRepository.findById(id)
                //Mapea si existe el plato, si existe entra la respuesta.
                .map(PlateMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Plate not found with id: " + id));
    }

    public PlateDTOResponse updatePlate(Long id, PlateDTORequest plateRequest) {

        //Toma el plato con el id ingresado, si no lo encuentra tira una exception.
        Plate existingPlate = plateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plate not found with id: " + id));

        // actualizar campos
        existingPlate.setName(plateRequest.plate_name());
        existingPlate.setDescription(plateRequest.plate_description());

        //Guarda el plato, ya actualizado en el mismo id.
        Plate updatedPlate = plateRepository.save(existingPlate);

        return PlateMapper.toResponse(updatedPlate);
    }

    public void deletePlateById(Long id) {

        Plate plate = plateRepository.findById(id).orElseThrow(() -> new RuntimeException("Plate not found with id: " + id));

        plateRepository.delete(plate);
    }
}
