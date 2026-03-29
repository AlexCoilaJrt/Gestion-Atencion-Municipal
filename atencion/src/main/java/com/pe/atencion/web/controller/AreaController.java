package com.pe.atencion.web.controller;

import com.pe.atencion.service.interfaces.IAreaService;
import com.pe.atencion.web.dto.request.AreaRequestDTO;
import com.pe.atencion.web.dto.response.AreaResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/areas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Para desarrollo con Angular
public class AreaController {

    private final IAreaService areaService;

    @GetMapping
    public ResponseEntity<List<AreaResponseDTO>> getAll() {
        return ResponseEntity.ok(areaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(areaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AreaResponseDTO> create(@Valid @RequestBody AreaRequestDTO requestDTO) {
        return new ResponseEntity<>(areaService.create(requestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody AreaRequestDTO requestDTO) {
        return ResponseEntity.ok(areaService.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        areaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> toggleStatus(@PathVariable Integer id) {
        areaService.toggleStatus(id);
        return ResponseEntity.ok().build();
    }
}
