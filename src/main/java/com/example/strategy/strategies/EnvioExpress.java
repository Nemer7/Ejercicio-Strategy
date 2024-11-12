package com.example.strategy.strategies;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.stereotype.Component;

@Component("EXPRESS")
public class EnvioExpress implements EstrategiaEnvio {
    @Override
    public double calcularCostoEnvio(double distancia) {
        return distancia * 1.5; // Tarifa express: $1.5 por kilómetro
    }
}
