package com.elranchoabelito.pedidos.services;


import com.elranchoabelito.pedidos.models.dtos.AddDetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.DetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;

import java.math.BigDecimal;
import java.util.List;

public interface IDetalleCarritoService {

    ResponseDetalleDeliveryDto addDetalleCarrito(CarritoCompra carritoCompra, AddDetalleDeliveryDTO detalleDeliveryDTO);

    List<DetalleDeliveryDTO> getDetalleCarritoByIdCarrito(CarritoCompra carritoCompra);

    BigDecimal sumTotalDetalles(List<DetalleDeliveryDTO> detalles);

}
