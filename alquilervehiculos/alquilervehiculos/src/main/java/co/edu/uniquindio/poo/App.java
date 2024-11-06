package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.controller.PrimaryController;
import co.edu.uniquindio.poo.model.Auto;
import co.edu.uniquindio.poo.model.Camioneta;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.EmpresaConcesionario;
import co.edu.uniquindio.poo.model.Moto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private EmpresaConcesionario concesionario;

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) {
        try {
            concesionario = new EmpresaConcesionario();
            cargarDatosIniciales();  // Cargar datos "quemados" al inicio

            // Cargar la vista principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/primary.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la vista principal
            PrimaryController primaryController = loader.getController();
            primaryController.setEmpresaConcesionario(concesionario);

            // Configurar la escena y mostrarla
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Sistema de Gestión de Alquiler de Vehículos");
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para cargar datos "quemados"
    private void cargarDatosIniciales() {
        // Datos de ejemplo para Clientes
        Cliente cliente1 = new Cliente(1, "Juan Pérez", "3001234567", "Calle 123");
        Cliente cliente2 = new Cliente(2, "Ana Gómez", "3007654321", "Carrera 45");
        concesionario.agregarCliente(cliente1);
        concesionario.agregarCliente(cliente2);

        // Datos de ejemplo para Vehículos
        Auto auto1 = new Auto("ABC123", "Toyota", "Corolla", 2020, 4);
        Moto moto1 = new Moto("DEF456", "Yamaha", "YZF", 2021, true);
        Camioneta camioneta1 = new Camioneta("GHI789", "Ford", "Ranger", 2019, 2.5);

        concesionario.agregarVehiculo(auto1);
        concesionario.agregarVehiculo(moto1);
        concesionario.agregarVehiculo(camioneta1);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
