package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "detalle_carrito_compra")
public class DetalleCarritoCompra {

    @EmbeddedId
    private DetalleCarritoCompraId id;

    @ManyToOne
    @MapsId("idCarrito")
    @JoinColumn(name = "id_carrito")
    private CarritoCompra carrito;

    @ManyToOne
    @JoinColumn(name = "estado_producto")
    private EstadoDetalleCarrito estado;

    private Integer cantidad;

    @Lob
    private String descripcion;

    private BigDecimal precio;
}
