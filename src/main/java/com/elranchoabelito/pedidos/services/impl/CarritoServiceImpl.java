package com.elranchoabelito.pedidos.services.impl;

import com.elranchoabelito.pedidos.mappers.CarritoMapper;
import com.elranchoabelito.pedidos.models.dtos.AddDetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.CarritoDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.repositories.CarritoRepository;
import com.elranchoabelito.pedidos.services.ICarritoService;
import com.elranchoabelito.pedidos.services.IDetalleCarritoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CarritoServiceImpl implements ICarritoService {

    private final CarritoRepository carritoRepository;
    private final IDetalleCarritoService detalleCarritoService;

    public CarritoServiceImpl(CarritoRepository carritoRepository, IDetalleCarritoService detalleCarritoService) {
        this.carritoRepository = carritoRepository;
        this.detalleCarritoService = detalleCarritoService;
    }

    @Override
    public ResponseCarritoDeliveryDto getCarritoCompra(String idCliente) {

        Integer idCarrito = existsCarritoWithoutPedido(idCliente);
        ResponseCarritoDeliveryDto carrito = new ResponseCarritoDeliveryDto();

        if (idCarrito == null) {
            carrito = createCarritoCompra(idCliente);
            carrito.setMensaje("No se encontro carrito disponibile. Nuevo Carrito Creado");
            carrito.setStatus("Nuevo Carrito");
        }else {
            carrito = CarritoMapper.toResponseCarritoDeliveryDto(findByIdCarrito(idCarrito));
            carrito.setMensaje("Carrito disponible encontrado");
            carrito.setStatus("Carrito reusado");
        }

        return carrito;
    }

    @Override
    public ResponseCarritoDeliveryDto createCarritoCompra(String idCliente) {

        CarritoCompra carritoCompra = new CarritoCompra();

        carritoCompra.setCreateAt(LocalDate.now());
        carritoCompra.setMontoCarrito(new BigDecimal(0));
        carritoCompra.setIdCliente(idCliente);

        CarritoCompra carritoSaved = carritoRepository.save(carritoCompra);

        return CarritoMapper.toResponseCarritoDeliveryDto(carritoSaved);
    }

    @Override
    public CarritoCompra findByIdCarrito(Integer idCarrito) {
        return carritoRepository.findById(idCarrito).orElseThrow(
                () -> new RuntimeException("El carrito no existe")
        );
    }

    @Override
    public CarritoDeliveryDTO getCarritoDeliveryByCliente(String idCliente) {
        Integer idCarrito = existsCarritoWithoutPedido(idCliente);
        CarritoCompra carrito = findByIdCarrito(idCarrito);
        CarritoDeliveryDTO carritoDeliveryDTO = CarritoMapper.toCarritoDeliveryDTO(carrito);
        carritoDeliveryDTO.setDetalles(detalleCarritoService.getDetalleCarritoByIdCarrito(carrito));
        carritoDeliveryDTO.setMonto(detalleCarritoService.sumTotalDetalles(carritoDeliveryDTO.getDetalles()));
        return carritoDeliveryDTO;
    }

    @Override
    public ResponseDetalleDeliveryDto addDetalleCarrito(AddDetalleDeliveryDTO createDetalleDeliveryDto) {
        CarritoCompra carritoCompra = findByIdCarrito(createDetalleDeliveryDto.getIdCarrito());
        return detalleCarritoService.addDetalleCarrito(carritoCompra, createDetalleDeliveryDto);
    }

    private Integer existsCarritoWithoutPedido(String idCliente) {
        return carritoRepository.findCarritoWithoutPedido(idCliente);
    }


}
