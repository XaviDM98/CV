package ejemplo;
import com.mycompany.mavenproject2.Reserva;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
public class ReservaTest {
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        // Configuración de fechas de prueba
        Calendar calendario = Calendar.getInstance();
        calendario.set(2024, Calendar.NOVEMBER, 11); // Fecha de inicio: 11 de noviembre de 2024
        Date fechaInicio = calendario.getTime();

        calendario.set(2024, Calendar.NOVEMBER, 15); // Fecha de fin: 15 de noviembre de 2024
        Date fechaFin = calendario.getTime();

        // Inicializa un objeto Reserva antes de cada prueba
        reserva = new Reserva("Suite", 2, fechaInicio, fechaFin);
    }

    @Test
    public void testCrearReserva() {
        assertEquals("Suite", reserva.getTipoHabitacion(), "El tipo de habitación debe ser 'Suite'");
        assertEquals(2, reserva.getNumeroHuespedes(), "El número de huéspedes debe ser 2");
        assertEquals(11, reserva.getFechaInicio().getDate(), "La fecha de inicio debe ser el 11 de noviembre");
        assertEquals(15, reserva.getFechaFin().getDate(), "La fecha de fin debe ser el 15 de noviembre");
    }

    @Test
    public void testPrecioTotal() {
        double precioEsperado = 100 * 2 * (4); // 4 noches de estancia
        assertEquals(precioEsperado, reserva.getPrecioTotal(), "El precio total debe ser calculado correctamente");
    }

    @Test
    public void testConfirmarReserva() {
        assertFalse(reserva.isConfirmada(), "La reserva no debe estar confirmada inicialmente");
        reserva.confirmarReserva();
        assertTrue(reserva.isConfirmada(), "La reserva debe estar confirmada después de llamar al método confirmarReserva");
    }

    @Test
    public void testToString() {
        String expected = "Reserva: Tipo de habitacion=Suite, Número de huespedes=2, Fecha de inicio=" +
                reserva.getFechaInicio() + ", Fecha de fin=" + reserva.getFechaFin() +
                ", Confirmada=false, Precio total=" + reserva.getPrecioTotal();
        assertEquals(expected, reserva.toString(), "El método toString debe devolver una representación correcta de la reserva");
    }
}
