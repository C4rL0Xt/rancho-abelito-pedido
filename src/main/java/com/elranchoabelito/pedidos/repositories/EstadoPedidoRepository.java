package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Integer> {

    Optional<EstadoPedido> findByNombreEstado(String nombreEstado);

}
