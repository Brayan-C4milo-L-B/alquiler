package co.edu.uniquindio.poo.model;
import java.time.LocalDate;

/*
* Clase camioneta
 */
public class Camioneta extends Vehiculo {
    private double capacidadCarga; // en toneladas

    public Camioneta(String matricula, String marca, String modelo, int añoFabricacion, double capacidadCarga) {
        super(matricula, marca, modelo, añoFabricacion);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        double tarifaBase = 70000; // Tarifa base por día para una camioneta
        return tarifaBase * dias + (capacidadCarga * 5000); // Costo adicional por tonelada de capacidad
    }

    // Getters y Setters
    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }
}

