package com.elranchoabelito.pedidos.models.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddDetalleDeliveryDTO {

    @NotNull(message = "Debe indicar un identificador del producto")
    private Integer idProducto;

    @Min(1)
    private Integer cantidad;

    private String descripcion;

    @NotNull(message = "Debe indicar un identificador para el carrito")
    private Integer idCarrito;

    @NotBlank(message = "Debe indicar un identificador para el cliente")
    private String idCliente;
}
