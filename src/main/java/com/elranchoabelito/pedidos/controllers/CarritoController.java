package com.elranchoabelito.pedidos.controllers;

import com.elranchoabelito.pedidos.models.dtos.AddDetalleDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.CarritoDeliveryDTO;
import com.elranchoabelito.pedidos.models.dtos.ResponseCarritoDeliveryDto;
import com.elranchoabelito.pedidos.models.dtos.ResponseDetalleDeliveryDto;
import com.elranchoabelito.pedidos.services.ICarritoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

@RestController
@RequestMapping("/carrito")
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

    @PostMapping("/add")
    public ResponseEntity<ResponseDetalleDeliveryDto> addDetallaToCarrito(@Valid @RequestBody AddDetalleDeliveryDTO dto) {
        ResponseDetalleDeliveryDto response = carritoService.addDetalleCarrito(dto);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/get/{idCliente}")
    public ResponseEntity<CarritoDeliveryDTO> getCarritoDetails(@PathVariable("idCliente") String idCliente) {
        CarritoDeliveryDTO carritoDeliveryDTO = carritoService.getCarritoDeliveryByCliente(idCliente);
        return ResponseEntity.ok(carritoDeliveryDTO);
    }

}
