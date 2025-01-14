package com.mycompany.mavenproject2;

public class Pago {
    private double monto;
    private String metodoPago;

    public Pago(double monto, String metodoPago) {
        this.monto = monto;
        this.metodoPago = metodoPago;
    }

    public boolean procesarPago() {
        System.out.println("Procesando pago de $" + monto + " mediante " + metodoPago);
        return true; // Simulación de éxito
    }

    public double getMonto() {
        return monto;
    }
}
