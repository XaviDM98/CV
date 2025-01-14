package ejemplo;
import com.mycompany.mavenproject2.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class NewEmptyJUnitTest {
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        // Inicializa un objeto Usuario antes de cada prueba
        usuario = new Usuario("Juan Pérez", "123456789", "juan.perez@example.com", "555-1234", "contrasenaSegura");
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Juan Pérez", usuario.getNombreCompleto(), "El nombre completo debe ser 'Juan Pérez'");
    }
    
    @Test
    public void testGetCorreoElectronico() {
        assertEquals("juan.perez@example.com", usuario.getCorreoElectronico(), "El correo electrónico debe ser 'juan.perez@example.com'");
    }
    
    @Test
    public void testGetNumeroContacto() {
        assertEquals("555-1234", usuario.getNumeroContacto(), "El número de contacto debe ser '555-1234'");
    }

    @Test
    public void testVerificarContrasenaCorrecta() {
        assertTrue(usuario.verificarContrasena("contrasenaSegura"), "La contraseña debe ser verificada correctamente");
    }

    @Test
    public void testVerificarContrasenaIncorrecta() {
        assertFalse(usuario.verificarContrasena("contrasenaIncorrecta"), "La contraseña incorrecta no debe ser verificada");
    }
}
