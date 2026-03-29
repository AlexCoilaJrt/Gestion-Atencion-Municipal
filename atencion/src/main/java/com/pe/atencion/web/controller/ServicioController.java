package com.pe.atencion.web.controller;

import com.pe.atencion.service.interfaces.IServicioService;
import com.pe.atencion.web.dto.request.ServicioRequestDTO;
import com.pe.atencion.web.dto.response.ServicioResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/servicios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServicioController {

    private final IServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> getAll() {
        return ResponseEntity.ok(servicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(servicioService.findById(id));
    }

    @GetMapping("/area/{areaId}")
    public ResponseEntity<List<ServicioResponseDTO>> getByArea(@PathVariable Integer areaId) {
        return ResponseEntity.ok(servicioService.findByArea(areaId));
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDTO> create(@Valid @RequestBody ServicioRequestDTO requestDTO) {
        return new ResponseEntity<>(servicioService.create(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody ServicioRequestDTO requestDTO) {
        return ResponseEntity.ok(servicioService.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> toggleStatus(@PathVariable Integer id) {
        servicioService.toggleStatus(id);
        return ResponseEntity.ok().build();
    }
}
