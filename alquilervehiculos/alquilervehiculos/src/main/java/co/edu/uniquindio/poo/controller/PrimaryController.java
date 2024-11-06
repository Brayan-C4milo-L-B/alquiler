package co.edu.uniquindio.poo.controller;

import co.edu.uniquindio.poo.model.EmpresaConcesionario;
import co.edu.uniquindio.poo.viewController.ViewClienteController;
import co.edu.uniquindio.poo.viewController.ViewVehiculoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {

    private EmpresaConcesionario concesionario;

    public void setEmpresaConcesionario(EmpresaConcesionario concesionario) {
        this.concesionario = concesionario;
    }

    public void abrirCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/crudCliente.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista de Cliente y pasarle el EmpresaConcesionario
            ViewClienteController clienteController = loader.getController();
            clienteController.setClienteController(new ClienteController(concesionario));

            Stage stage = new Stage();
            stage.setTitle("Gestión de Clientes");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirCrudVehiculo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/crudVehiculo.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista de Vehiculo y pasarle el EmpresaConcesionario
            ViewVehiculoController vehiculoController = loader.getController();
            vehiculoController.setVehiculoController(new VehiculoController(concesionario));

            Stage stage = new Stage();
            stage.setTitle("Gestión de Vehículos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salirAplicacion() {
        System.exit(0);
    }
}
