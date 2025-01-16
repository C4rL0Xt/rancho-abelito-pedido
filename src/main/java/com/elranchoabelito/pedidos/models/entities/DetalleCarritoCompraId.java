package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DetalleCarritoCompraId implements Serializable {

    private Integer idCarrito;

    private Integer idProducto;
}
