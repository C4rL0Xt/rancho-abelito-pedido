package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "estado_detalle")
public class EstadoDetalleCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_detalle_carrito")
    private Integer idEstadoDetalleCarrito;

    @Column(name = "nombre_estado")
    private String  nombreEstado;

    public EstadoDetalleCarrito() {
    }

    public EstadoDetalleCarrito(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

}
