
package com.example.strategy.service;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.stereotype.Service;

@Service
public class ProcesadorEnvio {

    private EstrategiaEnvio estrategiaEnvio;

    // Metodo para establecer la estrategia en tiempo de ejecución
    public void setEstrategia(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double procesarEnvio(double distancia) {
        if (estrategiaEnvio == null) {
            throw new IllegalStateException("Estrategia de envío no configurada");
        }
        return estrategiaEnvio.calcularCostoEnvio(distancia);
    }
}
