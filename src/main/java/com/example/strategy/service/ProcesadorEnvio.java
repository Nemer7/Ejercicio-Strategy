package com.example.strategy.service;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProcesadorEnvio {

    private final EstrategiaEnvio estrategiaEnvio;

    public ProcesadorEnvio(@Qualifier("ESTANDAR") EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double procesarEnvio(double distancia) {
        return estrategiaEnvio.calcularCostoEnvio(distancia);
    }

}
