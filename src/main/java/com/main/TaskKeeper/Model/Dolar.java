package com.main.TaskKeeper.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "dolar")
@Data
public class Dolar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "casa")
    private String casa;
    @Column(name = "compra")
    private Double compra;
    @Column(name = "venta")
    private Double venta;
    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

}
