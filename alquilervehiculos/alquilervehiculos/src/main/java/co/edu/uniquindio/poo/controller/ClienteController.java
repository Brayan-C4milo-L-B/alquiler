package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.EmpresaConcesionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClienteController {
    private EmpresaConcesionario concesionario;

    public ClienteController(EmpresaConcesionario concesionario) {
        this.concesionario = concesionario;
    }

    // Método para obtener la lista de clientes como ObservableList para JavaFX
    public ObservableList<Cliente> getClientesObservable() {
        return FXCollections.observableArrayList(concesionario.obtenerClientes());
    }

    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente) {
        concesionario.agregarCliente(cliente);
    }

    // Método para actualizar un cliente existente
    public void actualizarCliente(int id, Cliente clienteActualizado) {
        concesionario.actualizarCliente(id, clienteActualizado);
    }

    // Método para eliminar un cliente
    public void eliminarCliente(int id) {
        concesionario.eliminarCliente(id);
    }
}
