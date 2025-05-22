package org.example.parking;

import java.util.*;

public class Estacionamiento {
    private final int capacidadMaxima = 50;
    private final Map<String, Ticket> vehiculosEstacionados = new HashMap<>();
    private final Map<String, Cliente> clientesRegistrados = new HashMap<>();

    public boolean ingresarVehiculo(String dni, String nombre, Vehiculo vehiculo) {
        if (vehiculosEstacionados.size() >= capacidadMaxima) return false;
        if (vehiculosEstacionados.containsKey(vehiculo.getPatente())) return false;

        Cliente cliente = clientesRegistrados.get(dni);
        if (cliente == null) {
            cliente = new Cliente(dni, nombre);
            clientesRegistrados.put(dni, cliente);
        }

        cliente.agregarVehiculo(vehiculo);
        Ticket ticket = new Ticket(cliente, vehiculo);
        vehiculosEstacionados.put(vehiculo.getPatente(), ticket);

        return true;


    }

    public Ticket retirarVehiculo(String patente) throws Exception {
        if (!vehiculosEstacionados.containsKey(patente)) {
            throw new Exception("Vehiculo no encontrado");
        }

        Ticket ticket = vehiculosEstacionados.remove(patente);
        ticket.marcarSalida();
        return ticket;


    }

    public List<Ticket> listarVehiculosEstacionados() {
        return new ArrayList<>(vehiculosEstacionados.values());
    }
}
