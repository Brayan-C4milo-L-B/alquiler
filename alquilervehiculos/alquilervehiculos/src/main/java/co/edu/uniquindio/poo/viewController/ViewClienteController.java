package co.edu.uniquindio.poo.viewController;

import co.edu.uniquindio.poo.controller.ClienteController;
import co.edu.uniquindio.poo.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewClienteController {

    @FXML private TextField nombreField;
    @FXML private TextField telefonoField;
    @FXML private TextField direccionField;
    @FXML private TableView<Cliente> clientesTable;
    @FXML private TableColumn<Cliente, String> columnaNombre;
    @FXML private TableColumn<Cliente, String> columnaTelefono;
    @FXML private TableColumn<Cliente, String> columnaDireccion;
    @FXML private Button agregarCliente;
    @FXML private Button actualizarCliente;
    @FXML private Button eliminarCliente;

    private ClienteController clienteController;

    public void setClienteController(ClienteController clienteController) {
        this.clienteController = clienteController;
        cargarTablaClientes();
    }

    @FXML
    private void initialize() {
        // Configurar las columnas para que muestren las propiedades correctas
        columnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        columnaTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        columnaDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    @FXML
    private void agregarCliente() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        String direccion = direccionField.getText();

        Cliente nuevoCliente = new Cliente(0, nombre, telefono, direccion);
        clienteController.agregarCliente(nuevoCliente);
        cargarTablaClientes();
        limpiarCampos();
    }

    @FXML
    private void actualizarCliente() {
        Cliente clienteSeleccionado = clientesTable.getSelectionModel().getSelectedItem();
        if (clienteSeleccionado != null) {
            clienteSeleccionado.setNombre(nombreField.getText());
            clienteSeleccionado.setTelefono(telefonoField.getText());
            clienteSeleccionado.setDireccion(direccionField.getText());
            clienteController.actualizarCliente(clienteSeleccionado.getId(), clienteSeleccionado);
            cargarTablaClientes();
            limpiarCampos();
        }
    }

    @FXML
    private void eliminarCliente() {
        Cliente clienteSeleccionado = clientesTable.getSelectionModel().getSelectedItem();
        if (clienteSeleccionado != null) {
            clienteController.eliminarCliente(clienteSeleccionado.getId());
            cargarTablaClientes();
            limpiarCampos();
        }
    }

    private void cargarTablaClientes() {
        clientesTable.setItems(clienteController.getClientesObservable());
    }

    private void limpiarCampos() {
        nombreField.clear();
        telefonoField.clear();
        direccionField.clear();
    }
}
