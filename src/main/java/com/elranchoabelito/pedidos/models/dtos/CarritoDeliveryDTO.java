package com.elranchoabelito.pedidos.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class CarritoDeliveryDTO {

    private BigDecimal monto;
    List<DetalleDeliveryDTO> detalles;

    public CarritoDeliveryDTO(BigDecimal monto) {
        this.monto = monto;
    }
}
