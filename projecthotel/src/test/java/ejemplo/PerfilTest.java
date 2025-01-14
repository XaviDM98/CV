package ejemplo;
import com.mycompany.mavenproject2.Reserva;
import com.mycompany.mavenproject2.Perfil;
import com.mycompany.mavenproject2.Usuario;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class PerfilTest {
    private Usuario usuario;
    private Perfil perfil;

    @BeforeEach
    public void setUp() {
        // Inicializa un objeto Usuario y Perfil antes de cada prueba
        usuario = new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura");
        perfil = new Perfil(usuario);
    }

    @Test
    public void testCrearPerfil() {
        assertEquals(usuario, perfil.getUsuario(), "El usuario del perfil debe ser el mismo que el usuario creado");
        assertTrue(perfil.getHistorialReservas().isEmpty(), "El historial de reservas debe estar vacío al crear el perfil");
        assertEquals("", perfil.getPreferencias(), "Las preferencias deben estar vacías al crear el perfil");
    }

    @Test
    public void testAgregarReserva() {
        Calendar calendario = Calendar.getInstance();
        calendario.set(2024, Calendar.NOVEMBER, 11); // Fecha de inicio
        Date fechaInicio = calendario.getTime();

        calendario.set(2024, Calendar.NOVEMBER, 15); // Fecha de fin
        Date fechaFin = calendario.getTime();

        Reserva reserva = new Reserva("Suite", 2, fechaInicio, fechaFin);
        perfil.agregarReserva(reserva);

        assertEquals(1, perfil.getHistorialReservas().size(), "El historial de reservas debe contener una reserva");
        assertEquals(reserva, perfil.getHistorialReservas().get(0), "La reserva agregada debe ser la misma que la creada");
    }

    @Test
    public void testSetYGetPreferencias() {
        perfil.setPreferencias("Sin gluten, habitación de no fumadores");
        assertEquals("Sin gluten, habitación de no fumadores", perfil.getPreferencias(), "Las preferencias deben ser actualizadas correctamente");
    }

    @Test
    public void testToString() {
        String expected = "Perfil de Juan Pérez\nPreferencias: \nHistorial de Reservas: 0 reservas.";
        assertEquals(expected, perfil.toString(), "El método toString debe devolver una representación correcta del perfil");
    }
}
