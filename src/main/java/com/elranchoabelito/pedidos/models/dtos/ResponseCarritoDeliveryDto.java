package com.elranchoabelito.pedidos.models.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCarritoDeliveryDto {

    private Integer idCarrito;
    private BigDecimal total;
    private LocalDate fecha;
    private List<ResponseDetalleDeliveryDto> detalles;

    public ResponseCarritoDeliveryDto(Integer idCarrito, BigDecimal total, LocalDate fecha) {
        this.idCarrito = idCarrito;
        this.total = total;
        this.fecha = fecha;
    }

}
