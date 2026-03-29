package com.pe.atencion.service.impl;

import com.pe.atencion.persistence.entity.Area;
import com.pe.atencion.persistence.entity.Servicio;
import com.pe.atencion.persistence.repository.AreaRepository;
import com.pe.atencion.persistence.repository.ServicioRepository;
import com.pe.atencion.service.interfaces.IServicioService;
import com.pe.atencion.web.dto.request.ServicioRequestDTO;
import com.pe.atencion.web.dto.response.ServicioResponseDTO;
import com.pe.atencion.web.mapper.ServicioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements IServicioService {

    private final ServicioRepository servicioRepository;
    private final AreaRepository areaRepository;
    private final ServicioMapper servicioMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ServicioResponseDTO> findAll() {
        return servicioMapper.toResponseDTOList(servicioRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ServicioResponseDTO> findByArea(Integer areaId) {
        return servicioMapper.toResponseDTOList(servicioRepository.findByAreaId(areaId));
    }

    @Override
    @Transactional(readOnly = true)
    public ServicioResponseDTO findById(Integer id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));
        return servicioMapper.toResponseDTO(servicio);
    }

    @Override
    @Transactional
    public ServicioResponseDTO create(ServicioRequestDTO requestDTO) {
        Area area = areaRepository.findById(requestDTO.getAreaId())
                .orElseThrow(() -> new RuntimeException("Área no encontrada con ID: " + requestDTO.getAreaId()));
        
        Servicio servicio = servicioMapper.toEntity(requestDTO);
        servicio.setArea(area);
        
        return servicioMapper.toResponseDTO(servicioRepository.save(servicio));
    }

    @Override
    @Transactional
    public ServicioResponseDTO update(Integer id, ServicioRequestDTO requestDTO) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));
        
        Area area = areaRepository.findById(requestDTO.getAreaId())
                .orElseThrow(() -> new RuntimeException("Área no encontrada con ID: " + requestDTO.getAreaId()));
        
        servicioMapper.updateEntity(servicio, requestDTO);
        servicio.setArea(area);
        
        return servicioMapper.toResponseDTO(servicioRepository.save(servicio));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!servicioRepository.existsById(id)) {
            throw new RuntimeException("Servicio no encontrado con ID: " + id);
        }
        servicioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void toggleStatus(Integer id) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado con ID: " + id));
        servicio.setActivo(!servicio.getActivo());
        servicioRepository.save(servicio);
    }
}
