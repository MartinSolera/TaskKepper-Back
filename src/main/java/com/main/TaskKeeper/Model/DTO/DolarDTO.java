package com.main.TaskKeeper.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DolarDTO {
    private Long id;
    private String moneda;
    private String casa;
    private Double compra;
    private Double venta;
    private LocalDateTime fechaActualizacion;
}
