package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoCompra, Integer> {

    @Query(value = "SELECT c.id_carrito FROM carrito_compra c " +
            "WHERE c.pedido IS NULL " +
            "AND c.id_cliente = :idCliente", nativeQuery = true)
    Integer findCarritoWithoutPedido(@Param("idCliente") String idCliente);

}
