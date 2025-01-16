package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carrito_compra")
public class CarritoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito")
    private Integer idCarrito;

    @Column(name = "monto_carrito")
    private BigDecimal montoCarrito;

    @Column(name = "fecha_creacion")
    private LocalDate createAt;

    @OneToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;

    @Column(name = "id_cliente")
    private String idCliente;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    List<DetalleCarritoCompra> detalleCarritoCompra;

}
