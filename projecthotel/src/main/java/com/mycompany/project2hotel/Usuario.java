package com.mycompany.mavenproject2;

public class Usuario {
    private String nombreCompleto;
    private String cedula;
    private String correoElectronico;
    private String numeroContacto;
    private String contrasena;

    public Usuario(String nombreCompleto, String cedula, String correoElectronico, String numeroContacto, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
        this.numeroContacto = numeroContacto;
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}
