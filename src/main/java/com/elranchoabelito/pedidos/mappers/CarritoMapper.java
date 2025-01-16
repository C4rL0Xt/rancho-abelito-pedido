package com.elranchoabelito.pedidos.mappers;

import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;

public class CarritoMapper {


    public static ResponseCarritoDeliveryDto toResponseCarritoDeliveryDto(CarritoCompra carritoCompra) {
        return new ResponseCarritoDeliveryDto(
                carritoCompra.getIdCarrito(),
                carritoCompra.getMontoCarrito(),
                carritoCompra.getCreateAt()
        );
    }





}
