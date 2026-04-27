package com.Extraordinario.web.controllers;


import com.Extraordinario.web.controllers.Dtos.AvanzarEstadoDtos;
import com.Extraordinario.web.controllers.Dtos.CrearPedidoDtos;
import com.Extraordinario.web.modules.BeanPedido;
import com.Extraordinario.web.services.CompraService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/pedido")
@CrossOrigin({"*"})
public class ControllersCompra {
    private CompraService compraService;

    public ControllersCompra(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/avanzarestado")
    public BeanPedido avanzarestado(
            @RequestBody AvanzarEstadoDtos payload) {
        return compraService.avanzarestado(
                payload.pedidoid
        );
    }
    @PostMapping("/crearpedido")
    public BeanPedido crearpedido(
            @RequestBody CrearPedidoDtos payload) {
        return compraService.crearpedido(
                payload.pedidoid,
        );
    }
}
