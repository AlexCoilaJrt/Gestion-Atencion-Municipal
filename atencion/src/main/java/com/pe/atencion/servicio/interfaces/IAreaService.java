package com.pe.atencion.service.interfaces;

import com.pe.atencion.web.dto.request.AreaRequestDTO;
import com.pe.atencion.web.dto.response.AreaResponseDTO;

import java.util.List;

public interface IAreaService {
    List<AreaResponseDTO> findAll();
    AreaResponseDTO findById(Integer id);
    AreaResponseDTO create(AreaRequestDTO requestDTO);
    AreaResponseDTO update(Integer id, AreaRequestDTO requestDTO);
    void delete(Integer id);
    void toggleStatus(Integer id);
}
