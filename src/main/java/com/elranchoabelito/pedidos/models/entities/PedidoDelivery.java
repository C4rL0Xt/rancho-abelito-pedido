package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pedido_delivery")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDelivery extends Pedido {

    @Column(name = "id_cliente")
    private String idCliente;

    @Column(name = "id_transportista")
    private String idTransportista;
}
