package co.edu.uniquindio.poo.model;

/*
* Clase para reservas
 */
public class Reserva {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;

    public Reserva(Cliente cliente, Vehiculo vehiculo, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
    }

    public double calcularCosto() {
        return vehiculo.calcularCostoReserva(dias);
    }

    // Getters y setters

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", dias=" + dias +
                '}';
    }
}


