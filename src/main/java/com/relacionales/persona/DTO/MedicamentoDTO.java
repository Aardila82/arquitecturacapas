package com.relacionales.persona.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MedicamentoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Integer stock;
    private LocalDate fechaVencimiento;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;

}
