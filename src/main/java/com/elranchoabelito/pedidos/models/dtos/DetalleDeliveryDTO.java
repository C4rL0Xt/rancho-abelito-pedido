package com.elranchoabelito.pedidos.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleDeliveryDTO {

    private String nombreProducto;
    private String descripcionProducto;
    private BigDecimal precioProducto;
    private Integer cantidad;


}
