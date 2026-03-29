package com.pe.atencion.area.mapper;

import com.pe.atencion.area.dto.AreaRequestDTO;
import com.pe.atencion.area.dto.AreaResponseDTO;
import com.pe.atencion.area.entity.Area;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper {
    AreaResponseDTO toResponseDTO(Area area);
    List<AreaResponseDTO> toResponseDTOList(List<Area> areas);

    @Mapping(target = "id", ignore = true)
    Area toEntity(AreaRequestDTO requestDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Area area, AreaRequestDTO requestDTO);
}
