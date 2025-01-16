package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
