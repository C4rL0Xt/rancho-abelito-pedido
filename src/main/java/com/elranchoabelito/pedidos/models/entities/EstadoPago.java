package com.elranchoabelito.pedidos.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_pago")
@Builder
public class EstadoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;

    @Column(name = "nombre_estado")
    private String estadoPago;

    public EstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
