package com.elranchoabelito.pedidos.services.impl;

import com.elranchoabelito.pedidos.mappers.DetalleMapper;
import com.elranchoabelito.pedidos.models.dtos.AddDetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.DetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;
import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;
import com.elranchoabelito.pedidos.repositories.DetalleCarritoRepository;
import com.elranchoabelito.pedidos.services.IDetalleCarritoService;
import com.elranchoabelito.pedidos.services.IEstadoDetalleService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleDeliveryServiceImpl implements IDetalleCarritoService {

    private static final Logger logger = LoggerFactory.getLogger(DetalleDeliveryServiceImpl.class);

    private final DetalleCarritoRepository detalleCarritoRepository;
    private final IEstadoDetalleService estadoService;

    public DetalleDeliveryServiceImpl(DetalleCarritoRepository detalleCarritoRepository, IEstadoDetalleService estadoService) {
        this.detalleCarritoRepository = detalleCarritoRepository;

        this.estadoService = estadoService;
    }

    @Override
    @Transactional
    public ResponseDetalleDeliveryDto addDetalleCarrito(CarritoCompra carritoCompra, AddDetalleDeliveryDTO detalleDeliveryDTO) {

        EstadoDetalleCarrito estadoDetalleCarrito = estadoService.findByEstado("PENDIENTE");
        BigDecimal precio = new BigDecimal(detalleDeliveryDTO.getCantidad() * 10);

        DetalleCarritoCompra detalleCarritoCompra = DetalleMapper.toDetalleCarritoCompra(detalleDeliveryDTO,carritoCompra,estadoDetalleCarrito,precio);
        DetalleCarritoCompra detalleSaved = detalleCarritoRepository.save(detalleCarritoCompra);
        DetalleDeliveryDTO detalleDeliveryDTO2 = DetalleMapper.detalleDeliveryDTO(detalleSaved);

        String message = detalleSaved != null ? "Producto agregado correctamente al carrito" : "Error al agregar Producto al carrito";
        String status = detalleSaved != null ? "Sucess" : "Error";

        return new ResponseDetalleDeliveryDto(
                message,
                status,
                detalleDeliveryDTO2
        );
    }

    @Override
    public List<DetalleDeliveryDTO> getDetalleCarritoByIdCarrito(CarritoCompra carritoCompra) {

        List<DetalleCarritoCompra> detalleCarritoCompras = detalleCarritoRepository.findByCarrito(carritoCompra);
        List<DetalleDeliveryDTO> detalles = new ArrayList<>();

        detalles = detalleCarritoCompras.stream().map(DetalleMapper::detalleDeliveryDTO)
                .toList();

        return detalles;
    }

    @Override
    public BigDecimal sumTotalDetalles(List<DetalleDeliveryDTO> detalles) {
        return detalles.stream()
                .map(DetalleDeliveryDTO::getPrecioProducto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
