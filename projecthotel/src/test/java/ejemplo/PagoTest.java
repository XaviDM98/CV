package ejemplo;
import com.mycompany.mavenproject2.Pago;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class PagoTest {
    private Pago pago;

    @BeforeEach
    public void setUp() {
        // Inicializa un objeto Pago antes de cada prueba
        pago = new Pago(150.0, "Tarjeta de Crédito");
    }

    /*@Test
    public void testCrearPago() {
        assertEquals(150.0, pago.getMonto(), "El monto debe ser 150.0");
        assertEquals("Tarjeta de Crédito", pago.getMetodoPago(), "El método de pago debe ser 'Tarjeta de Crédito'");
    }*/

    @Test
    public void testProcesarPago() {
        assertTrue(pago.procesarPago(), "El procesamiento del pago debe devolver true");
    }

    @Test
    public void testMontoNegativo() {
        Pago pagoNegativo = new Pago(-50.0, "Efectivo");
        assertEquals(-50.0, pagoNegativo.getMonto(), "El monto debe ser -50.0");
    }

    @Test
    public void testMontoCero() {
        Pago pagoCero = new Pago(0.0, "Transferencia");
        assertEquals(0.0, pagoCero.getMonto(), "El monto debe ser 0.0");
    }
}
