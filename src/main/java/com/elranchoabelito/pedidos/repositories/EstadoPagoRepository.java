package com.elranchoabelito.pedidos.repositories;

import com.elranchoabelito.pedidos.models.entities.EstadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoPagoRepository extends JpaRepository<EstadoPago, Integer> {

    Optional<EstadoPago> findByEstadoPago(String estadoPago);
}
