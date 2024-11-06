package co.edu.uniquindio.poo.model;


/*
* Clase moto
 */
public class Moto extends Vehiculo {
    private boolean esAutomatica;

    public Moto(String matricula, String marca, String modelo, int añoFabricacion, boolean esAutomatica) {
        super(matricula, marca, modelo, añoFabricacion);
        this.esAutomatica = esAutomatica;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        double tarifaBase = 30000; // Tarifa base por día para una moto
        if (esAutomatica) {
            tarifaBase += 10000; // Costo adicional si es automática
        }
        return tarifaBase * dias;
    }

    // Getters y Setters
    public boolean isEsAutomatica() { return esAutomatica; }
    public void setEsAutomatica(boolean esAutomatica) { this.esAutomatica = esAutomatica; }
}

