package com.example.strategy.controller;

import com.example.strategy.factory.EstrategiaEnvioFactory;
import com.example.strategy.service.ProcesadorEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/envio")
public class EnvioController {

    private final EstrategiaEnvioFactory estrategiaEnvioFactory;

    @Autowired
    public EnvioController(EstrategiaEnvioFactory estrategiaEnvioFactory) {
        this.estrategiaEnvioFactory = estrategiaEnvioFactory;
    }

    @PostMapping("/procesar")
    public double procesarEnvio(@RequestParam String tipoEnvio, @RequestParam double distancia) {
        var estrategia = estrategiaEnvioFactory.obtenerEstrategia(tipoEnvio);
        var procesadorEnvio = new ProcesadorEnvio(estrategia);
        return procesadorEnvio.procesarEnvio(distancia);
    }
}
