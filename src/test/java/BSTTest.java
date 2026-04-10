import edu.uvg.Association;
import edu.uvg.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para los métodos insert() y search() de BinaryTree.
 * Cada test es independiente gracias a la inicialización en setUp().
 *
 * @autor Weslly Cabrera
 */
public class BSTTest {

    private BinaryTree<String, String> tree;

    /**
     * Se ejecuta antes de cada test.
     * Inicializa un árbol limpio para garantizar que los tests
     * no se afecten entre sí.
     */
    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
    }

    /**
     * Verifica que un elemento recién insertado puede ser encontrado.
     * Es la prueba más básica de que insert() funciona correctamente.
     */
    @Test
    void testInsertEncuentraElementoInsertado() {
        tree.insert("maison", "casa");
        assertNotNull(tree.search("maison"));
    }

    /**
     * Verifica que se pueden insertar múltiples elementos y todos
     * pueden ser encontrados correctamente en el árbol.
     */
    @Test
    void testInsertMultiplesElementos() {
        tree.insert("oui", "si");
        tree.insert("maison", "casa");
        tree.insert("chien", "perro");
        assertNotNull(tree.search("oui"));
        assertNotNull(tree.search("maison"));
        assertNotNull(tree.search("chien"));
    }

    /**
     * Verifica que search() retorna la asociación correcta,
     * comprobando tanto la clave como el valor del resultado.
     */
    @Test
    void testSearchEncuentraElemento() {
        tree.insert("femme", "mujer");
        Association<String, String> result = tree.search("femme");
        assertNotNull(result);
        assertEquals("femme", result.getKey());
        assertEquals("mujer", result.getValue());
    }

    /**
     * Verifica que search() retorna null cuando la clave
     * buscada no existe en el árbol.
     */
    @Test
    void testSearchNoEncuentraElemento() {
        tree.insert("femme", "mujer");
        assertNull(tree.search("chien"));
    }

    /**
     * Verifica que search() retorna null cuando el árbol
     * está completamente vacío.
     */
    @Test
    void testSearchArbolVacio() {
        assertNull(tree.search("oui"));
    }

    /**
     * Verifica que el recorrido in-order retorna todas las asociaciones
     * ordenadas alfabéticamente por clave francesa.
     */
    @Test
    void testInOrderRetornaOrdenAlfabetico() {
        tree.insert("oui", "si");
        tree.insert("maison", "casa");
        tree.insert("chien", "perro");
        tree.insert("devoirs", "tarea");

        var result = tree.inOrder();

        assertEquals("chien", result.get(0).getKey());
        assertEquals("devoirs", result.get(1).getKey());
        assertEquals("maison", result.get(2).getKey());
        assertEquals("oui", result.get(3).getKey());
    }
}
