package co.edu.uniquindio.poo.model;

/*
* Clase padre
 */
// Clase base para los vehículos
public abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int añoFabricacion;

    public Vehiculo(String matricula, String marca, String modelo, int añoFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.añoFabricacion = añoFabricacion;
    }

    public abstract double calcularCostoReserva(int dias);

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAñoFabricacion() { return añoFabricacion; }
    public void setAñoFabricacion(int añoFabricacion) { this.añoFabricacion = añoFabricacion; }
}