package com.pe.atencion.area.service.impl;

import com.pe.atencion.area.dto.AreaRequestDTO;
import com.pe.atencion.area.dto.AreaResponseDTO;
import com.pe.atencion.area.entity.Area;
import com.pe.atencion.area.mapper.AreaMapper;
import com.pe.atencion.area.repository.AreaRepository;
import com.pe.atencion.area.service.IAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements IAreaService {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AreaResponseDTO> findAll() {
        return areaMapper.toResponseDTOList(areaRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public AreaResponseDTO findById(Integer id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada con ID: " + id));
        return areaMapper.toResponseDTO(area);
    }

    @Override
    @Transactional
    public AreaResponseDTO create(AreaRequestDTO requestDTO) {
        Area area = areaMapper.toEntity(requestDTO);
        return areaMapper.toResponseDTO(areaRepository.save(area));
    }

    @Override
    @Transactional
    public AreaResponseDTO update(Integer id, AreaRequestDTO requestDTO) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada con ID: " + id));
        
        areaMapper.updateEntity(area, requestDTO);
        return areaMapper.toResponseDTO(areaRepository.save(area));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (!areaRepository.existsById(id)) {
            throw new RuntimeException("Área no encontrada con ID: " + id);
        }
        areaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void toggleStatus(Integer id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Área no encontrada con ID: " + id));
        area.setActivo(!area.getActivo());
        areaRepository.save(area);
    }
}
