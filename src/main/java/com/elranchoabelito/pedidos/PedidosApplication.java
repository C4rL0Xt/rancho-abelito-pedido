package com.elranchoabelito.pedidos;

import com.elranchoabelito.pedidos.models.entities.EstadoDetalleCarrito;
import com.elranchoabelito.pedidos.models.entities.EstadoPago;
import com.elranchoabelito.pedidos.models.entities.EstadoPedido;
import com.elranchoabelito.pedidos.repositories.EstadoDetalleCarritoRepository;
import com.elranchoabelito.pedidos.repositories.EstadoPagoRepository;
import com.elranchoabelito.pedidos.repositories.EstadoPedidoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidosApplication.class, args);
    }


    @Bean
    public CommandLineRunner initData(
            EstadoPedidoRepository estadoPedidoRepository,
            EstadoPagoRepository estadoPagoRepository,
            EstadoDetalleCarritoRepository estadoDetalleCarritoRepository
    ) {
        return args -> {
            /*
            EstadoDetalleCarrito estadoC1 = estadoDetalleCarritoRepository.findByNombreEstado("PENDIENTE")
                    .orElseGet(
                            () -> estadoDetalleCarritoRepository.save(new EstadoDetalleCarrito("PENDIENTE"))
                    );
            EstadoDetalleCarrito estadoC2 = estadoDetalleCarritoRepository.findByNombreEstado("PREPARADO")
                    .orElseGet(
                            () -> estadoDetalleCarritoRepository.save(new EstadoDetalleCarrito("PREPARADO"))
                    );
            EstadoDetalleCarrito estadoC3 = estadoDetalleCarritoRepository.findByNombreEstado("PREPARANDO")
                    .orElseGet(
                            () -> estadoDetalleCarritoRepository.save(new EstadoDetalleCarrito("PREPARANDO"))
                    );

            EstadoPago pago1 = estadoPagoRepository.findByEstadoPago("PENDIENTE")
                    .orElseGet(
                            () -> estadoPagoRepository.save(new EstadoPago("PENDIENTE"))
                    );

            EstadoPago pago2 = estadoPagoRepository.findByEstadoPago("PAGADO")
                    .orElseGet(
                            () -> estadoPagoRepository.save(new EstadoPago("PAGADO"))
                    );


            EstadoPedido estadoPedido1 = estadoPedidoRepository.findByNombreEstado("PREPARANDO")
                    .orElseGet(
                            () -> estadoPedidoRepository.save(new EstadoPedido("PREPARANDO"))
                    );
            EstadoPedido estadoPedido2 = estadoPedidoRepository.findByNombreEstado("EN CAMINO")
                    .orElseGet(
                            () -> estadoPedidoRepository.save(new EstadoPedido("EN CAMINO"))
                    );

            EstadoPedido estadoPedido3 = estadoPedidoRepository.findByNombreEstado("LISTO PARA ENVIAR")
                    .orElseGet(
                            () -> estadoPedidoRepository.save(new EstadoPedido("LISTO PARA ENVIAR"))
                    );

            EstadoPedido estadoPedido4 = estadoPedidoRepository.findByNombreEstado("PENDIENTE")
                    .orElseGet(
                            () -> estadoPedidoRepository.save(new EstadoPedido("PENDIENTE"))
                    );

            EstadoPedido estadoPedido5 = estadoPedidoRepository.findByNombreEstado("ENTREGADO")
                    .orElseGet(
                            () -> estadoPedidoRepository.save(new EstadoPedido("ENTREGADO"))
                    );

             */
        };
    }

}
