package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_pedido")
public class EstadoPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoPedido;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    public EstadoPedido(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
