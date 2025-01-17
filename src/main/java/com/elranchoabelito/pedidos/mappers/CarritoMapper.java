package com.elranchoabelito.pedidos.mappers;

import com.elranchoabelito.pedidos.models.dtos.CarritoDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;

public class CarritoMapper {


    public static ResponseCarritoDeliveryDto toResponseCarritoDeliveryDto(CarritoCompra carritoCompra) {
        return new ResponseCarritoDeliveryDto(
                carritoCompra.getIdCarrito()
        );
    }

    public static CarritoDeliveryDTO toCarritoDeliveryDTO(CarritoCompra carritoCompra) {
        return new CarritoDeliveryDTO(
                carritoCompra.getMontoCarrito()
        );
    }





}
