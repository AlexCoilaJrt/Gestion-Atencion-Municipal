package com.pe.atencion.area.service;

import com.pe.atencion.area.dto.AreaRequestDTO;
import com.pe.atencion.area.dto.AreaResponseDTO;

import java.util.List;

public interface IAreaService {
    List<AreaResponseDTO> findAll();
    AreaResponseDTO findById(Integer id);
    AreaResponseDTO create(AreaRequestDTO requestDTO);
    AreaResponseDTO update(Integer id, AreaRequestDTO requestDTO);
    void delete(Integer id);
    void toggleStatus(Integer id);
}
