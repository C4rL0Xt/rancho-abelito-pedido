package com.elranchoabelito.pedidos.models.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ResponseCarritoDeliveryDto {

    private Integer idCarrito;
    private String mensaje;
    private String status;

    public ResponseCarritoDeliveryDto(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

}
