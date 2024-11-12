package com.example.strategy.factory;

import com.example.strategy.interfaces.EstrategiaEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EstrategiaEnvioFactory {

    private final Map<String, EstrategiaEnvio> estrategias;

    @Autowired
    public EstrategiaEnvioFactory(Map<String, EstrategiaEnvio> estrategias) {
        this.estrategias = estrategias;
    }

    public EstrategiaEnvio obtenerEstrategia(String tipoEnvio) {
        EstrategiaEnvio estrategia = estrategias.get(tipoEnvio);
        if (estrategia == null) {
            throw new IllegalArgumentException("Tipo de envío no soportado: " + tipoEnvio);
        }
        return estrategia;
    }
}
