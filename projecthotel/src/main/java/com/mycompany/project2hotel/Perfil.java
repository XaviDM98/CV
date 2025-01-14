package com.mycompany.mavenproject2;
import java.util.ArrayList;
import java.util.List;

public class Perfil {
    private Usuario usuario;
    private List<Reserva> historialReservas;
    private String preferencias;

    public Perfil(Usuario usuario) {
        this.usuario = usuario;
        this.historialReservas = new ArrayList<>();
        this.preferencias = "";
    }

    public void agregarReserva(Reserva reserva) {
        historialReservas.add(reserva);
    }

    public List<Reserva> getHistorialReservas() {
        return historialReservas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public String getPreferencias() {
        return preferencias;
    }

    @Override
    public String toString() {
        return "Perfil de " + usuario.getNombreCompleto() +
               "\nPreferencias: " + preferencias +
               "\nHistorial de Reservas: " + historialReservas.size() + " reservas.";
    }
}
