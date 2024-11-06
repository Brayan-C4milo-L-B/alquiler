package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.VehiculoController;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewVehiculoController {

    @FXML private TextField matriculaField;
    @FXML private TextField marcaField;
    @FXML private TextField modeloField;
    @FXML private TextField añoFabricacionField;
    @FXML private TextField diasReservaField;
    @FXML private TableView<Vehiculo> vehiculosTable;
    @FXML private TableColumn<Vehiculo, String> columnaMatricula;
    @FXML private TableColumn<Vehiculo, String> columnaMarca;
    @FXML private TableColumn<Vehiculo, String> columnaModelo;
    @FXML private TableColumn<Vehiculo, String> columnaAñoFabricacion;
    @FXML private Button agregarVehiculo;
    @FXML private Button actualizarVehiculo;
    @FXML private Button eliminarVehiculo;
    @FXML private Button calcularCostoButton;
    @FXML private Label costoReservaLabel;

    private VehiculoController vehiculoController;

    public void setVehiculoController(VehiculoController vehiculoController) {
        this.vehiculoController = vehiculoController;
        cargarTablaVehiculos();
    }

    @FXML
    private void initialize() {
        // Configurar las columnas para que muestren las propiedades correctas
        columnaMatricula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMatricula()));
        columnaMarca.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        columnaModelo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        columnaAñoFabricacion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAñoFabricacion())));
    }

    @FXML
    private void agregarVehiculo() {
        String matricula = matriculaField.getText();
        String marca = marcaField.getText();
        String modelo = modeloField.getText();
        int añoFabricacion = Integer.parseInt(añoFabricacionField.getText());

        Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, añoFabricacion) {
            @Override
            public double calcularCostoReserva(int dias) {
                return 0;
            }
        }; // Crear nuevo vehículo
        vehiculoController.agregarVehiculo(nuevoVehiculo);
        cargarTablaVehiculos();
        limpiarCampos();
    }

    @FXML
    private void actualizarVehiculo() {
        Vehiculo vehiculoSeleccionado = vehiculosTable.getSelectionModel().getSelectedItem();
        if (vehiculoSeleccionado != null) {
            vehiculoSeleccionado.setMarca(marcaField.getText());
            vehiculoSeleccionado.setModelo(modeloField.getText());
            vehiculoSeleccionado.setAñoFabricacion(Integer.parseInt(añoFabricacionField.getText()));
            vehiculoController.actualizarVehiculo(vehiculoSeleccionado.getMatricula(), vehiculoSeleccionado);
            cargarTablaVehiculos();
            limpiarCampos();
        }
    }

    @FXML
    private void eliminarVehiculo() {
        Vehiculo vehiculoSeleccionado = vehiculosTable.getSelectionModel().getSelectedItem();
        if (vehiculoSeleccionado != null) {
            vehiculoController.eliminarVehiculo(vehiculoSeleccionado.getMatricula());
            cargarTablaVehiculos();
            limpiarCampos();
        }
    }

    @FXML
    private void calcularCostoReserva() {
        Vehiculo vehiculoSeleccionado = vehiculosTable.getSelectionModel().getSelectedItem();
        if (vehiculoSeleccionado != null && !diasReservaField.getText().isEmpty()) {
            try {
                int diasReserva = Integer.parseInt(diasReservaField.getText());
                double costo = vehiculoSeleccionado.calcularCostoReserva(diasReserva);
                costoReservaLabel.setText("Costo de Reserva: $" + costo);
            } catch (NumberFormatException e) {
                costoReservaLabel.setText("Ingrese un número válido de días.");
            }
        } else {
            costoReservaLabel.setText("Seleccione un vehículo y días válidos.");
        }
    }

    private void cargarTablaVehiculos() {
        vehiculosTable.setItems(vehiculoController.getVehiculosObservable());
    }

    private void limpiarCampos() {
        matriculaField.clear();
        marcaField.clear();
        modeloField.clear();
        añoFabricacionField.clear();
        diasReservaField.clear();
        costoReservaLabel.setText("Costo de Reserva: ");
    }

    


    
}
