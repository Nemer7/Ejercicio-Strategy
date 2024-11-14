package com.example.strategy.controller;

import com.example.strategy.factory.EstrategiaEnvioFactory;
import com.example.strategy.service.ProcesadorEnvio;
import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/envio")
public class EnvioController {

    private final EstrategiaEnvioFactory estrategiaEnvioFactory;
    private final ProcesadorEnvio procesadorEnvio;

    @Autowired
    public EnvioController(EstrategiaEnvioFactory estrategiaEnvioFactory, ProcesadorEnvio procesadorEnvio) {
        this.estrategiaEnvioFactory = estrategiaEnvioFactory;
        this.procesadorEnvio = procesadorEnvio;
    }

    @PostMapping("/procesar")
    public double procesarEnvio(@RequestParam String tipoEnvio, @RequestParam double distancia) {
        EstrategiaEnvio estrategia = estrategiaEnvioFactory.obtenerEstrategia(tipoEnvio);
        procesadorEnvio.setEstrategia(estrategia); // Configuramos la estrategia
        return procesadorEnvio.procesarEnvio(distancia);
    }
}
