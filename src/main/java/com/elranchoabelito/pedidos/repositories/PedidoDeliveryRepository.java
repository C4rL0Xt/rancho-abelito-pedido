package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.PedidoDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDeliveryRepository extends JpaRepository<PedidoDelivery, Integer> {

}
