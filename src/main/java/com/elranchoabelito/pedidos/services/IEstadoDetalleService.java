package com.elranchoabelito.pedidos.services;

import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;

public interface IEstadoDetalleService {

    EstadoDetalleCarrito findByEstado(String estado);
}
