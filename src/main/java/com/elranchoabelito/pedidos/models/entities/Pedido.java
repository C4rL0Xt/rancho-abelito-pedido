package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pedidos")
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @ManyToOne
    @JoinColumn(name = "estado_pedido")
    private EstadoPedido estadoPedido;

    @ManyToOne
    @JoinColumn(name = "estado_pago")
    private EstadoPago estadoPago;

    /*@OneToOne
    @JoinColumn(name = "carrito_id")
    private CarritoCompra carritoCompra;*/

    @Column(name = "fecha_creacion")
    private LocalTime createdAt;

    private BigDecimal total;

}
