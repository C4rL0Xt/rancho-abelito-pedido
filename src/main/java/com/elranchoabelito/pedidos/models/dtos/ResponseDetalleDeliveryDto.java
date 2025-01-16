package com.elranchoabelito.pedidos.models.dtos;

import lombok.*;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDetalleDeliveryDto {

    private String mensaje;
    private String status;
    private DetalleDeliveryDTO detalleDelivery;

}
