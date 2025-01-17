package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompra;
import com.elranchoabelito.pedidos.models.entities.DetalleCarritoCompraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCarritoRepository extends JpaRepository<DetalleCarritoCompra, DetalleCarritoCompraId> {

    List<DetalleCarritoCompra> findByCarrito(CarritoCompra carrito);


}
