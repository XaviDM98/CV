package com.mycompany.mavenproject2;

public class Habitacion {
    private String tipo;
    private double precio;
    private boolean ocupada;

    public Habitacion(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
        this.ocupada = false;
    }

    public void marcarComoOcupada() {
        this.ocupada = true;
    }

    public void marcarComoDisponible() {
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}
