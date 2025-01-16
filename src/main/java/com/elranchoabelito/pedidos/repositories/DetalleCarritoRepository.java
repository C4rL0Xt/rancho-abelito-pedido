package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarritoCompra, DetalleCarritoCompraId> {
}
