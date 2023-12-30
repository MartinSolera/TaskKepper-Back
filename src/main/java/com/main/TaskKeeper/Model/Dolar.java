package com.main.TaskKeeper.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Dolar {

    private String moneda;
    private String casa;
    private Double compra;
    private Double venta;
    private LocalDateTime fechaActualizacion;

}
