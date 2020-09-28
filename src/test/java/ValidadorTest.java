import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase que incluye las pruebas unitarias de la clase Validador
 */
public class ValidadorTest {

    Validador v;

    @Before
    public void setUp() throws Exception {
        v = new Validador();
    }

    @After
    public void tearDown() throws Exception {
        v = null;
    }

    /**
     * Test para revisar que esInt() acepta ints válidos
     */
    @Test
    public void esInt1() {
        assertTrue(v.esInt("0"));
        assertTrue(v.esInt("100"));
        assertTrue(v.esInt("-256"));
        assertTrue(v.esInt("-2147483648")); // Valor mínimo de un int
        assertTrue(v.esInt("2147483647")); // Valor máximo de un int
    }

    /**
     * Test para revisar que esInt() no acepta números demasiado grandes
     */
    @Test
    public void esInt2() {
        assertFalse(v.esInt("23172617381238"));
        assertFalse(v.esInt("-92347821332912"));
        assertFalse(v.esInt("-2147483649")); // Valor mínimo de un int -1
        assertFalse(v.esInt("2147483648")); // Valor máximo de un int +1
    }

    /**
     * Test para revisar que esInt() no acepta símbolos o letras
     */
    @Test
    public void esInt3() {
        assertFalse(v.esInt("A"));
        assertFalse(v.esInt("asdasda"));
        assertFalse(v.esInt("!\"#=?"));
        assertFalse(v.esInt(" "));
        assertFalse(v.esInt("         "));
    }

    /**
     * Test para revisar que esInt() no acepta entrada nula
     */
    @Test
    public void esInt4() {
        assertFalse(v.esInt(null));
    }

    /**
     * Test para revisar que esNumeroTelefonico() acepta números de teléfono válidos
     */
    @Test
    public void esNumeroTelefonico1() {
        assertTrue(v.esNumeroTelefonico("912345678"));
        assertTrue(v.esNumeroTelefonico("133"));
        assertTrue(v.esNumeroTelefonico("911"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() también acepta números de teléfonos válidos si se antepone un +
     */
    @Test
    public void esNumeroTelefonico2() {
        assertTrue(v.esNumeroTelefonico("+56971717171"));
        assertTrue(v.esNumeroTelefonico("+123456789"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta números en otros formatos
     */
    @Test
    public void esNumeroTelefonico3() {
        assertFalse(v.esNumeroTelefonico("+56 111 222 333"));
        assertFalse(v.esNumeroTelefonico("+123-456-789"));
        assertFalse(v.esNumeroTelefonico("1 0 3"));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta entrada que tenga símbolos
     */
    @Test
    public void esNumeroTelefonico4() {
        assertFalse(v.esNumeroTelefonico("+"));
        assertFalse(v.esNumeroTelefonico("asdfsdghasd"));
        assertFalse(v.esNumeroTelefonico(" "));
    }

    /**
     * Test para revisar que esNumeroTelefonico() no acepta entrada nula
     */
    @Test
    public void esNumeroTelefonico5() {
        assertFalse(v.esNumeroTelefonico(null));
    }

    /**
     * Test para revisar que esEmail() acepta emails válidos
     */
    @Test
    public void esEmail1() {
        assertTrue(v.esEmail("v.mardones07@gmail.com"));
        assertTrue(v.esEmail("l.burgos08@ufromail.cl"));
        assertTrue(v.esEmail("b.munoz15@hotmail.com"));
    }

    /**
     * Test para revisar que esEmail() no acepta emails no válidos
     */
    @Test
    public void esEmail2() {
        assertFalse(v.esEmail("0.#$s.213"));
        assertFalse(v.esEmail("..."));
        assertFalse(v.esEmail("holamundo"));
    }

    /**
     * Test para revisar que esEmail() no acepta entrada nula
     */
    @Test
    public void esEmail3() {
        assertFalse(v.esEmail(null));
    }
}