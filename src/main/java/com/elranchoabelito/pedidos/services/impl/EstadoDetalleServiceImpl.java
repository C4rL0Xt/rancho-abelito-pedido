package com.elranchoabelito.pedidos.services.impl;

import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;
import com.elranchoabelito.pedidos.repositories.EstadoDetalleCarritoRepository;
import com.elranchoabelito.pedidos.services.IEstadoDetalleService;
import org.springframework.stereotype.Service;

@Service
public class EstadoDetalleServiceImpl implements IEstadoDetalleService {

    private final EstadoDetalleCarritoRepository estadoDetalleCarritoRepository;

    public EstadoDetalleServiceImpl(EstadoDetalleCarritoRepository estadoDetalleCarritoRepository) {
        this.estadoDetalleCarritoRepository = estadoDetalleCarritoRepository;
    }

    @Override
    public EstadoDetalleCarrito findByEstado(String estado) {
        return estadoDetalleCarritoRepository.findByNombreEstado(estado).orElseThrow(
                () -> new RuntimeException("Estado no encontrado")
        );
    }
}
