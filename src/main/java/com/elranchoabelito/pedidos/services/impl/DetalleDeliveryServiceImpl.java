package com.elranchoabelito.pedidos.services.impl;

import com.elranchoabelito.pedidos.mappers.DetalleMapper;
import com.elranchoabelito.pedidos.models.dtos.CreateDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.DetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompraId;
import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;
import com.elranchoabelito.pedidos.repositories.DetalleCarritoRepository;
import com.elranchoabelito.pedidos.services.ICarritoService;
import com.elranchoabelito.pedidos.services.IDetalleCarritoService;
import com.elranchoabelito.pedidos.services.IEstadoDetalleService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DetalleDeliveryServiceImpl implements IDetalleCarritoService {

    private final DetalleCarritoRepository detalleCarritoRepository;
    private final ICarritoService carritoService;
    private final IEstadoDetalleService estadoService;

    public DetalleDeliveryServiceImpl(DetalleCarritoRepository detalleCarritoRepository, ICarritoService carritoService, IEstadoDetalleService estadoService) {
        this.detalleCarritoRepository = detalleCarritoRepository;
        this.carritoService = carritoService;
        this.estadoService = estadoService;
    }

    @Override
    public ResponseDetalleDeliveryDto addDetalleCarrito(CreateDetalleDeliveryDto detalleDeliveryDTO) {

        String message = "";
        String status = "";

        CarritoCompra carritoCompra = carritoService.findByIdCarrito(detalleDeliveryDTO.getIdCarrito());
        EstadoDetalleCarrito estadoDetalleCarrito = estadoService.findByEstado("PENDIENTE");
        BigDecimal precio = new BigDecimal(detalleDeliveryDTO.getCantidad() * 10);

        DetalleCarritoCompra detalleCarritoCompra = DetalleMapper.toDetalleCarritoCompra(detalleDeliveryDTO,carritoCompra,estadoDetalleCarrito,precio);
        DetalleCarritoCompra detalleSaved = detalleCarritoRepository.save(detalleCarritoCompra);
        DetalleDeliveryDTO detalleDeliveryDTO2 = DetalleMapper.detalleDeliveryDTO(detalleSaved);

        if (detalleSaved != null) {
            status = "sucess";
            message = "Producto agregado correctamente al carrito";
        }
        else {
            message = "Error al agregar Producto al carrito";
            status = "Bad Request";
        }


        ResponseDetalleDeliveryDto responseDetalleDeliveryDto = new ResponseDetalleDeliveryDto(
                message,
                status,
                detalleDeliveryDTO2
        );




        return responseDetalleDeliveryDto;
    }
}
