package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoDetalleCarritoRepository extends JpaRepository<EstadoDetalleCarrito, Integer> {

    Optional<EstadoDetalleCarrito> findByNombreEstado(String estado);

}
