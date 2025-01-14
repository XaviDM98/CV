package com.mycompany.mavenproject2;
import java.util.Date;

public class Reserva {
    private String tipoHabitacion;
    private int numeroHuespedes;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean confirmada;
    private double precioTotal;

    public Reserva(String tipoHabitacion, int numeroHuespedes, Date fechaInicio, Date fechaFin) {
        this.tipoHabitacion = tipoHabitacion;
        this.numeroHuespedes = numeroHuespedes;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.confirmada = false;
        this.precioTotal = calcularPrecioTotal();
    }

    private double calcularPrecioTotal() {
        // Suponiendo que el precio base por noche es 100, ajusta según los requisitos
        return 100 * numeroHuespedes * (1 + (fechaFin.getTime() - fechaInicio.getTime()) / (1000 * 60 * 60 * 24));
    }

    public void confirmarReserva() {
        this.confirmada = true;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public int getNumeroHuespedes() {
        return numeroHuespedes;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return "Reserva: Tipo de habitacion=" + tipoHabitacion +
                ", Número de huespedes=" + numeroHuespedes +
                ", Fecha de inicio=" + fechaInicio +
                ", Fecha de fin=" + fechaFin +
                ", Confirmada=" + confirmada +
                ", Precio total=" + precioTotal;
    }
}
