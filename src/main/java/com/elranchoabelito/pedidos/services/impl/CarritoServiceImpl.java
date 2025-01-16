package com.elranchoabelito.pedidos.services.impl;

import com.elranchoabelito.pedidos.mappers.CarritoMapper;
import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.repositories.CarritoRepository;
import com.elranchoabelito.pedidos.services.ICarritoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class CarritoServiceImpl implements ICarritoService {

    private final CarritoRepository carritoRepository;

    public CarritoServiceImpl(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    @Override
    public ResponseCarritoDeliveryDto getCarritoCompra(String idCliente) {

        Integer idCarrito = existsCarritoWithoutPedido(idCliente);
        ResponseCarritoDeliveryDto carrito = new ResponseCarritoDeliveryDto();

        if (idCarrito == null)
            carrito = createCarritoCompra(idCliente);
        else
            carrito = CarritoMapper.toResponseCarritoDeliveryDto(findByIdCarrito(idCarrito));

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


    private Integer existsCarritoWithoutPedido(String idCliente) {
        return carritoRepository.findCarritoWithoutPedido(idCliente);
    }


}
