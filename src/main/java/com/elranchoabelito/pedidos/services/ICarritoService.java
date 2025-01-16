package com.elranchoabelito.pedidos.services;

import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;

public interface ICarritoService {

    ResponseCarritoDeliveryDto createCarritoCompra(String idCliente);

    ResponseCarritoDeliveryDto getCarritoCompra(String idCliente);

    CarritoCompra findByIdCarrito(Integer idCarrito);


}
