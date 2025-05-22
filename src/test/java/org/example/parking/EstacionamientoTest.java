package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        Estacionamiento estacionamiento = new Estacionamiento();
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota 86", Vehiculo.Tipo.AUTO);
        String dni = "12345678";
        String nombre = "Juan Lopez";


        boolean ingreso = estacionamiento.ingresarVehiculo(dni, nombre, vehiculo);
        assertTrue(ingreso, "El vehiculo deberia haber ingresado correctamente");


        Ticket ticket = estacionamiento.retirarVehiculo("ABC123");
        assertNotNull(ticket, "El ticket devuelto no deberia ser null");


        long minutos = ticket.calcularMinutos();
        assertTrue(minutos > 0, "El tiempo de permanencia deberia ser mayor a 0 minutos");


        assertEquals(0, estacionamiento.listarVehiculosEstacionados().size(), "No deberian quedar vehículos estacionados");
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        Vehiculo vehiculo = new Vehiculo("XYZ789", "Audi A5", Vehiculo.Tipo.PICKUP);
        Cliente cliente = new Cliente("87654321", "Maria Gimenez");
        Ticket ticket = new Ticket(cliente, vehiculo);


        ticket.marcarSalida();


        double precio = ticket.calcularPrecio();
        assertTrue(precio >= 180, "El precio mínimo por 1 hora para PICKUP debería ser 180");

    }

}