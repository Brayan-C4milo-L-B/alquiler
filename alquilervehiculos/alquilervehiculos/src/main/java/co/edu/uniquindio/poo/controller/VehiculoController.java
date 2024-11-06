package co.edu.uniquindio.poo.controller;


import co.edu.uniquindio.poo.model.EmpresaConcesionario;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VehiculoController {
    private EmpresaConcesionario concesionario;

    public VehiculoController(EmpresaConcesionario concesionario) {
        this.concesionario = concesionario;
    }

    // Método para obtener la lista de vehículos como ObservableList para JavaFX
    public ObservableList<Vehiculo> getVehiculosObservable() {
        return FXCollections.observableArrayList(concesionario.obtenerVehiculos());
    }

    // Método para agregar un vehículo
    public void agregarVehiculo(Vehiculo vehiculo) {
        concesionario.agregarVehiculo(vehiculo);
    }

    // Método para actualizar un vehículo existente
    public void actualizarVehiculo(String matricula, Vehiculo vehiculoActualizado) {
        concesionario.actualizarVehiculo(matricula, vehiculoActualizado);
    }

    // Método para eliminar un vehículo
    public void eliminarVehiculo(String matricula) {
        concesionario.eliminarVehiculo(matricula);
 
    }

    
}
