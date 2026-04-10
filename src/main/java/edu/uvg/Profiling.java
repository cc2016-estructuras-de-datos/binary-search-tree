package edu.uvg;

/**
 * Profiling de los métodos insert() y search() de BinaryTree.
 * Mide el tiempo de ejecución con un volumen grande de palabras
 * para analizar el comportamiento del árbol.
 *
 * @autor Weslly Cabrera
 */
public class Profiling {

    public static void main(String[] args) {

        BinaryTree<String, String> tree = new BinaryTree<>();

        // Se generan n palabras simuladas para alimentar el árbol
        int n = 100000;
        String[] keys = new String[n];
        String[] values = new String[n];

        for (int i = 0; i < n; i++) {
            keys[i] = "palabra" + i;
            values[i] = "traducción" + i;
        }

        System.out.println("Profiling de insert");
        System.out.println("Insertando " + n + " elementos");

        long startInsert = System.nanoTime();
        for (int i = 0; i < n; i++) {
            tree.insert(keys[i], values[i]);
        }
        long endInsert = System.nanoTime();

        long totalInsert = endInsert - startInsert;
        System.out.println("Tiempo total de inserción: " + totalInsert / 1_000_000 + " ms");
        System.out.println("Tiempo promedio por insert: " + totalInsert / n + " ns");

        System.out.println("\nProfiling de search");
        System.out.println("Buscando " + n + " elementos");

        long startSearch = System.nanoTime();
        for (int i = 0; i < n; i++) {
            tree.search(keys[i]);
        }
        long endSearch = System.nanoTime();

        long totalSearch = endSearch - startSearch;
        System.out.println("Tiempo total de búsqueda: " + totalSearch / 1_000_000 + " ms");
        System.out.println("Tiempo promedio por search: " + totalSearch / n + " ns");

        System.out.println("\nElementos procesados: " + n);
        System.out.println("Insert total: " + totalInsert / 1_000_000 + " ms");
        System.out.println("Search total: " + totalSearch / 1_000_000 + " ms");
    }
}
