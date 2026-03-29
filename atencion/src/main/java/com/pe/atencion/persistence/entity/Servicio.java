package com.pe.atencion.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa un trámite o servicio específico dentro de un área.
 */
@Entity
@Table(name = "servicios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "tiempo_promedio_atencion")
    @Builder.Default
    private Integer tiempoPromedioAtencion = 15;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;
}
