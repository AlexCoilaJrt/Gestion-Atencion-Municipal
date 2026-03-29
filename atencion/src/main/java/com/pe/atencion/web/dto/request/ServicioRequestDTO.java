package com.pe.atencion.web.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioRequestDTO {

    @NotNull(message = "El id del área es obligatorio")
    private Integer areaId;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150)
    private String nombre;

    private String descripcion;

    @Min(value = 1, message = "El tiempo mínimo es 1 minuto")
    private Integer tiempoPromedioAtencion;

    private Boolean activo;
}
