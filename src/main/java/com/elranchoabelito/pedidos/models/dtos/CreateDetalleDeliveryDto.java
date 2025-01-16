package com.elranchoabelito.pedidos.models.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDetalleDeliveryDto {

    private Integer idProducto;
    private Integer cantidad;
    private String descripcion;
    private Integer idCarrito;
    private String idCliente;
}
