package com.elranchoabelito.pedidos.controllers;

import com.elranchoabelito.pedidos.models.dtos.CreateDetalleDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.services.IDetalleCarritoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalleCarritoController {

    private final IDetalleCarritoService detalleCarritoService;

    public DetalleCarritoController(IDetalleCarritoService detalleCarritoService) {
        this.detalleCarritoService = detalleCarritoService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDetalleDeliveryDto> addDetalle(@RequestBody CreateDetalleDeliveryDto dto) {
        ResponseDetalleDeliveryDto response = detalleCarritoService.addDetalleCarrito(dto);
        return ResponseEntity.ok(response);
    }

}
