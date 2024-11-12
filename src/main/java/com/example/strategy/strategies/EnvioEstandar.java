package com.example.strategy.strategies;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.stereotype.Component;

@Component("ESTANDAR")
public class EnvioEstandar implements EstrategiaEnvio {
    @Override
    public double calcularCostoEnvio(double distancia) {
        return distancia * 1.0; // Tarifa estándar: $1 por kilómetro
    }
}
