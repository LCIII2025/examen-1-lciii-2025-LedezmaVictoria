package org.example.parking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@AllArgsConstructor
public class Ticket {
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;

    public Ticket(Cliente cliente, Vehiculo vehiculo) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.horaEntrada = LocalDateTime.now();
    }

    public void marcarSalida() {
        Random random = new Random();
        this.horaSalida = horaEntrada.plusMinutes(random.nextInt(200) + 1);
    }

    public long calcularMinutos() {
        return Duration.between(horaEntrada, horaSalida).toMinutes();
    }

    public double calcularPrecio() {
        long minutos = calcularMinutos();
        double horas = Math.ceil(minutos / 60.0);
        double tarifaPorHora = switch (vehiculo.getTipo()) {
            case AUTO -> 100;
            case SUV -> 130;
            case PICKUP -> 180;
        };
        return horas * tarifaPorHora;


    }

}