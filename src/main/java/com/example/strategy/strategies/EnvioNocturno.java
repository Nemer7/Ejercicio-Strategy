package com.example.strategy.strategies;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.stereotype.Component;

@Component("NOCTURNO")
public class EnvioNocturno implements EstrategiaEnvio {
    @Override
    public double calcularCostoEnvio(double distancia) {
        return distancia * 2.0; // Tarifa nocturna: $2 por kilómetro
    }
}
