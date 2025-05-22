package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehiculo {
    public enum Tipo {
        AUTO, SUV, PICKUP
    }

    private final String patente;
    private final String modelo;
    private final Tipo tipo;

    public Vehiculo(String patente, String modelo, Tipo tipo) {
        this.patente = patente;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public Tipo getTipo() {
        return tipo;
    }


}
