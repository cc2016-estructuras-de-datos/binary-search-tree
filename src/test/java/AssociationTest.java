import edu.uvg.Association;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Pruebas unitarias para la clase Association.
 *
 * @autor Weslly Cabrera
 */
public class AssociationTest {

    /**
     * Verifica que el constructor asigna correctamente la clave y el valor.
     */
    @Test
    void testConstructor() {
        Association<String, String> association = new Association<>("maison", "casa");
        assertEquals("maison", association.getKey());
        assertEquals("casa", association.getValue());
    }

    /**
     * Verifica que setValue actualiza el valor correctamente.
     */
    @Test
    void testSetValue() {
        Association<String, String> association = new Association<>("maison", "casa");
        association.setValue("hogar");
        assertEquals("hogar", association.getValue());
    }

    /**
     * Verifica que toString retorna el formato correcto (frances, español).
     */
    @Test
    void testToString() {
        Association<String, String> association = new Association<>("chien", "perro");
        assertEquals("(chien, perro)", association.toString());
    }
}
