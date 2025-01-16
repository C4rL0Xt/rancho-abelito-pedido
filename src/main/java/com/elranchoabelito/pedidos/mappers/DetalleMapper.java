package com.elranchoabelito.pedidos.mappers;

import com.elranchoabelito.pedidos.models.dtos.CreateDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.DetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompraId;
import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;

import java.math.BigDecimal;

public class DetalleMapper {


    public static DetalleCarritoCompra toDetalleCarritoCompra(CreateDetalleDeliveryDto detalleDeliveryDto, CarritoCompra carritoCompra, EstadoDetalleCarrito estado, BigDecimal precio) {
        DetalleCarritoCompra detalleCarritoCompra = new DetalleCarritoCompra();
        DetalleCarritoCompraId detalleCarritoCompraId = new DetalleCarritoCompraId();

        detalleCarritoCompraId.setIdCarrito(carritoCompra.getIdCarrito());
        detalleCarritoCompraId.setIdProducto(detalleDeliveryDto.getIdProducto());

        detalleCarritoCompra.setCarrito(carritoCompra);
        detalleCarritoCompra.setId(detalleCarritoCompraId);
        detalleCarritoCompra.setDescripcion(detalleDeliveryDto.getDescripcion());
        detalleCarritoCompra.setCantidad(detalleDeliveryDto.getCantidad());
        detalleCarritoCompra.setPrecio(precio);
        detalleCarritoCompra.setEstado(estado);

        return detalleCarritoCompra;
    }

    public static DetalleDeliveryDTO detalleDeliveryDTO(DetalleCarritoCompra detalleCarritoCompra) {
        DetalleDeliveryDTO detalleDeliveryDTO = new DetalleDeliveryDTO();

        detalleDeliveryDTO.setCantidad(detalleCarritoCompra.getCantidad());
        detalleDeliveryDTO.setDescripcionProducto(detalleCarritoCompra.getDescripcion());
        detalleDeliveryDTO.setNombreProducto("Producto Prueba");
        detalleDeliveryDTO.setPrecioProducto(detalleCarritoCompra.getPrecio());

        return detalleDeliveryDTO;
    }
}
