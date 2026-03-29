package com.pe.atencion.web.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioResponseDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer tiempoPromedioAtencion;
    private Boolean activo;
    private Integer areaId;
    private String areaNombre; // Útil para mostrar en el frontend sin hacer otra petición
}
