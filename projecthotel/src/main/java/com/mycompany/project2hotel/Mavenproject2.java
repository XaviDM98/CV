package com.mycompany.mavenproject2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Mavenproject2 {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Habitacion> habitaciones = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        Mavenproject2 app = new Mavenproject2(); // Crear una instancia de Mavenproject2
        app.ejecutar(); // Llamar al método ejecutar
    }
    public void ejecutar(){
        habitaciones.add(new Habitacion("Simple", 100));
        habitaciones.add(new Habitacion("Doble", 150));
        habitaciones.add(new Habitacion("Suite", 250));

        while (true) {
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion.");
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
    private static void registrarUsuario() {
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese su cedula: ");
        String cedula = scanner.nextLine();
        System.out.print("Ingrese su correo electronico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su numero de contacto: ");
        String numeroContacto = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contrasena = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombreCompleto, cedula, correo, numeroContacto, contrasena);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con exito.");
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese su correo o numero de contacto: ");
        String contacto = scanner.nextLine();
        System.out.print("Ingrese su contrasena: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = validarUsuario(contacto, contrasena);
        if (usuario != null) {
            System.out.println("Inicio de sesion exitoso.");
            gestionarReservas(usuario);
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    private static Usuario validarUsuario(String contacto, String contrasena) {
        for (Usuario usuario : usuarios) {
            if ((usuario.getCorreoElectronico().equals(contacto) || usuario.getNumeroContacto().equals(contacto)) &&
                usuario.verificarContrasena(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    private static void gestionarReservas(Usuario usuario) {
        while (true) {
            System.out.println("\n1. Buscar habitaciones");
            System.out.println("2. Hacer reserva");
            System.out.println("3. Ver reservas");
            System.out.println("4. Cerrar sesion");
            System.out.print("Elija una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarHabitaciones();
                    break;
                case 2:
                    hacerReserva(usuario);
                    break;
                case 3:
                    verReservas(usuario);
                    break;
                case 4:
                    System.out.println("Cerrando sesion.");
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private static void buscarHabitaciones() {
        System.out.println("Habitaciones disponibles:");
        for (Habitacion habitacion : habitaciones) {
            if (!habitacion.isOcupada()) {
                System.out.println("Tipo: " + habitacion.getTipo() + ", Precio: " + habitacion.getPrecio());
            }
        }
    }

    private static void hacerReserva(Usuario usuario) {
        System.out.print("Ingrese el tipo de habitacion que desea reservar: ");
        String tipoHabitacion = scanner.nextLine();
        System.out.print("Ingrese el numero de huespedes: ");
        int numeroHuespedes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio (dd/MM/yyyy): ");
        String fechaInicioStr = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (dd/MM/yyyy): ");
        String fechaFinStr = scanner.nextLine();

        try {
            Date fechaInicio = dateFormat.parse(fechaInicioStr);
            Date fechaFin = dateFormat.parse(fechaFinStr);

            Reserva nuevaReserva = new Reserva(tipoHabitacion, numeroHuespedes, fechaInicio, fechaFin);
            reservas.add(nuevaReserva);
            nuevaReserva.confirmarReserva();

            System.out.print("Ingrese el metodo de pago: ");
            String metodoPago = scanner.nextLine();
            Pago pago = new Pago(nuevaReserva.getPrecioTotal(), metodoPago);
            if (pago.procesarPago()) {
                System.out.println("Reserva realizada con exito.");
            } else {
                System.out.println("Error en el procesamiento del pago.");
            }

        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Intente nuevamente.");
        }
    }

    private static void verReservas(Usuario usuario) {
        System.out.println("Reservas de " + usuario.getNombreCompleto() + ":");
        for (Reserva reserva : reservas) {
            System.out.println("Tipo de habitacion: " + reserva.getTipoHabitacion() + ", Confirmada: " + reserva.isConfirmada());
        }
    }
}
