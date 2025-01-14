package ejemplo;
import com.mycompany.mavenproject2.Habitacion;
import com.mycompany.mavenproject2.Reserva;
import com.mycompany.mavenproject2.Usuario;
import com.mycompany.mavenproject2.Mavenproject2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MavenProjectCajaNegraTest {
    private List<Usuario> usuarios;
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;
    private Scanner scanner;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        usuarios = new ArrayList<>();
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();
        scanner = new Scanner(System.in);
        originalOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));
        
        // Agregar habitaciones para las pruebas
        habitaciones.add(new Habitacion("Simple", 100));
        habitaciones.add(new Habitacion("Doble", 150));
        habitaciones.add(new Habitacion("Suite", 250));
    }

    @Test
    public void testRegistroUsuarioExitoso() {
        String input = "Juan Pérez\n123456789\njuan.perez@example.com\n555-1234\ncontrasenaSegura\n3\n"; // Opción 3 para salir
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(usuarios.size() > 0, "Debería haber al menos un usuario registrado.");
        assertEquals("Juan Pérez", usuarios.get(0).getNombreCompleto(), "El nombre del usuario registrado debe ser 'Juan Pérez'.");
        assertTrue(outputStreamCaptor.toString().contains("Usuario registrado con exito."), "Debería mostrar un mensaje de éxito.");
    }

    @Test
    public void testInicioSesionExitoso() {
        // Registrar un usuario primero
        usuarios.add(new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura"));

        String input = "juan.perez@example.com\ncontrasenaSegura\n1\n4\n"; // Opción 1 para buscar habitaciones y luego cerrar sesión
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Inicio de sesion exitoso."), "Debería mostrar un mensaje de inicio de sesión exitoso.");
    }

    @Test
    public void testInicioSesionFallido() {
        // No registrar ningún usuario
        String input = "usuario.inexistente@example.com\nmalContrasena\n3\n"; // Opción 3 para salir
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Credenciales incorrectas."), "Debería mostrar un mensaje de credenciales incorrectas.");
    }

    @Test
    public void testBuscarHabitaciones() {
        // Registrar un usuario primero
        usuarios.add(new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura"));

        String input = "juan.perez@example.com\ncontrasenaSegura\n1\n4\n"; // Opción 1 para buscar habitaciones y luego cerrar sesión
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Habitaciones disponibles:"), "Debería mostrar la lista de habitaciones disponibles.");
    }

    @Test
    public void testReservaExitosa() {
        // Registrar un usuario primero
        usuarios.add(new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura"));

        String input = "juan.perez@example.com\ncontrasenaSegura\n2\nSimple\n2\n01/01/2025\n02/01/2025\nPagoConTarjeta\n4\n"; // Hacer reserva y luego cerrar sesión
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Reserva realizada con exito."), "Debería mostrar un mensaje de reserva exitosa.");
    }

    @Test
    public void testReservaConFechaIncorrecta() {
        // Registrar un usuario primero
        usuarios.add(new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura"));

        String input = "juan.perez@example.com\ncontrasenaSegura\n2\nSimple\n2\n01/01/2025\nfechaIncorrecta\n4\n"; // Hacer reserva con fecha incorrecta
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Formato de fecha incorrecto. Intente nuevamente."), "Debería mostrar un mensaje de error de formato de fecha.");
    }

    @Test
    public void testSalidaDelSistema() {
        String input = "3\n"; // Opción 3 para salir
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Mavenproject2 app = new Mavenproject2();
        app.ejecutar();

        assertTrue(outputStreamCaptor.toString().contains("Saliendo de la aplicacion."), "Debería mostrar un mensaje de salida.");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut); // Restaurar la salida original
    }
}
