package edu.uvg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Diccionario Francés-Español implementado sobre un BST.
 * Se encarga de cargar el diccionario desde un archivo,
 * traducir texto en francés y mostrar las asociaciones ordenadas.
 *
 * @autor Weslly Cabrera
 */
public class BSTDictionary {

    private BinaryTree<String, String> tree;

    public BSTDictionary() {
        this.tree = new BinaryTree<>();
    }

    /**
     * Carga las asociaciones desde un archivo con formato (frances, español).
     * Cada línea del archivo debe tener el formato: (palabra, traduccion)
     *
     * @param filePath ruta del archivo diccionario.txt
     */
    public void loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    parseLine(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + filePath);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Parsea una línea con formato (frances, español) y la inserta en el árbol.
     * La clave se guarda en minúsculas para facilitar búsquedas case-insensitive.
     *
     * @param line línea a parsear
     */
    private void parseLine(String line) {
        // Eliminar paréntesis: (oui, si) -> oui, si
        line = line.replace("(", "").replace(")", "");

        // Separar por coma
        String[] parts = line.split(",");

        if (parts.length == 2) {
            String french = parts[0].trim().toLowerCase();
            String spanish = parts[1].trim().toLowerCase();
            tree.insert(french, spanish);
        }
    }

    /**
     * Traduce una palabra del francés al español.
     * Si no existe en el diccionario, retorna la palabra entre asteriscos.
     *
     * @param word palabra en francés a traducir
     * @return traducción en español o *palabra* si no existe
     */
    public String translate(String word) {
        Association<String, String> result = tree.search(word.toLowerCase());
        if (result != null) {
            return result.getValue();
        }
        return "*" + word + "*";
    }

    /**
     * Traduce un texto completo en francés al español palabra por palabra.
     * Preserva los espacios entre palabras.
     *
     * @param filePath ruta del archivo texto.txt
     */
    public void translateFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                StringBuilder translated = new StringBuilder();

                for (int i = 0; i < words.length; i++) {
                    translated.append(translate(words[i]));
                    if (i < words.length - 1) {
                        translated.append(" ");
                    }
                }
                System.out.println(translated);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + filePath);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Imprime todas las asociaciones del diccionario
     * ordenadas alfabéticamente por la palabra en francés.
     */
    public void printInOrder() {
        List<Association<String, String>> sorted = tree.inOrder();
        StringBuilder sb = new StringBuilder();

        for (Association<String, String> association : sorted) {
            sb.append(association.toString()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
