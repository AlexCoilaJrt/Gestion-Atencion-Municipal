package com.pe.atencion.service.interfaces;

import com.pe.atencion.web.dto.request.ServicioRequestDTO;
import com.pe.atencion.web.dto.response.ServicioResponseDTO;

import java.util.List;

public interface IServicioService {
    List<ServicioResponseDTO> findAll();
    List<ServicioResponseDTO> findByArea(Integer areaId);
    ServicioResponseDTO findById(Integer id);
    ServicioResponseDTO create(ServicioRequestDTO requestDTO);
    ServicioResponseDTO update(Integer id, ServicioRequestDTO requestDTO);
    void delete(Integer id);
    void toggleStatus(Integer id);
}
