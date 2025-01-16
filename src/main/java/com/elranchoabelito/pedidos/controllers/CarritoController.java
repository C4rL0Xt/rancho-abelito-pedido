package com.elranchoabelito.pedidos.controllers;

import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.services.ICarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarritoController {

    private final ICarritoService carritoService;

    public CarritoController(ICarritoService carritoService) {
        this.carritoService = carritoService;
    }


    @PostMapping("/check/{idCliente}")
    public ResponseEntity<ResponseCarritoDeliveryDto> getCarritoCompra(@PathVariable("idCliente") String idCliente) {
        ResponseCarritoDeliveryDto response = carritoService.getCarritoCompra(idCliente);
        return ResponseEntity.ok(response);
    }


}
