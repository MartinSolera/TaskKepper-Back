package com.main.TaskKeeper.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dolar {

    private String moneda;
    private String casa;
    private Double compra;
    private Double venta;
    private LocalDateTime fechaActualizacion;

}
