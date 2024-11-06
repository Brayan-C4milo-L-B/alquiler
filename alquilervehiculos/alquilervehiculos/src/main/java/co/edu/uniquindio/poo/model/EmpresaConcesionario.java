package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class EmpresaConcesionario {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    // CRUD para Cliente
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void actualizarCliente(int id, Cliente clienteActualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setTelefono(clienteActualizado.getTelefono());
                cliente.setDireccion(clienteActualizado.getDireccion());
                return;
            }
        }
    }

    public void eliminarCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    // CRUD para Vehiculo
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void actualizarVehiculo(String matricula, Vehiculo vehiculoActualizado) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculo.setMarca(vehiculoActualizado.getMarca());
                vehiculo.setModelo(vehiculoActualizado.getModelo());
                vehiculo.setAñoFabricacion(vehiculoActualizado.getAñoFabricacion());
                return;
            }
        }
    }

    public void eliminarVehiculo(String matricula) {
        vehiculos.removeIf(vehiculo -> vehiculo.getMatricula().equals(matricula));
    }

    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    // CRUD para Reserva
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void eliminarReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public List<Reserva> obtenerReservas() {
        return reservas;
    }
}
