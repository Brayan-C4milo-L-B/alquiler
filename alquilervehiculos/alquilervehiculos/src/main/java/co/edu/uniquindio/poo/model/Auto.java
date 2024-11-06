package co.edu.uniquindio.poo.model;

public class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String matricula, String marca, String modelo, int añoFabricacion, int numeroPuertas) {
        super(matricula, marca, modelo, añoFabricacion);
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularCostoReserva(int dias) {
        double tarifaBase = 50000; // Tarifa base por día para un auto
        return tarifaBase * dias;
    }

    // Getters y Setters
    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }
}