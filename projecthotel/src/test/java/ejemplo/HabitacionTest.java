package ejemplo;
import com.mycompany.mavenproject2.Habitacion;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HabitacionTest {
    private Habitacion habitacion;

    @BeforeEach
    public void setUp() {
        // Inicializa un objeto Habitacion antes de cada prueba
        habitacion = new Habitacion("Suite", 150.0);
    }

    @Test
    public void testCrearHabitacion() {
        assertEquals("Suite", habitacion.getTipo(), "El tipo de habitación debe ser 'Suite'");
        assertEquals(150.0, habitacion.getPrecio(), "El precio de la habitación debe ser 150.0");
        assertFalse(habitacion.isOcupada(), "La habitación no debe estar ocupada al crearla");
    }

    @Test
    public void testMarcarComoOcupada() {
        habitacion.marcarComoOcupada();
        assertTrue(habitacion.isOcupada(), "La habitación debe estar ocupada después de marcarla como ocupada");
    }

    @Test
    public void testMarcarComoDisponible() {
        habitacion.marcarComoOcupada(); // Primero la marcamos como ocupada
        habitacion.marcarComoDisponible(); // Luego la marcamos como disponible
        assertFalse(habitacion.isOcupada(), "La habitación debe estar disponible después de marcarla como disponible");
    }

    @Test
    public void testPrecio() {
        assertEquals(150.0, habitacion.getPrecio(), "El precio debe ser 150.0");
    }

    @Test
    public void testTipo() {
        assertEquals("Suite", habitacion.getTipo(), "El tipo de habitación debe ser 'Suite'");
    }
}
