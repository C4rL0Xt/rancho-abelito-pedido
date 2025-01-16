package com.elranchoabelito.pedidos.services;


import com.elranchoabelito.pedidos.models.dtos.CreateDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.DetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;

public interface IDetalleCarritoService {

    ResponseDetalleDeliveryDto addDetalleCarrito(CreateDetalleDeliveryDto detalleDeliveryDTO);

}
