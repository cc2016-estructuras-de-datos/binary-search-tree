package edu.uvg;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de un Árbol Binario de Búsqueda (BST).
 * Soporta inserción, búsqueda y recorrido in-order.
 *
 * @param <K> el tipo de la clave, debe ser Comparable
 * @param <V> el tipo del valor asociado a la clave
 *
 * @autor Weslly Cabrera
 */
public class BinaryTree<K extends Comparable<K>, V> {

    private BSTNode<Association<K, V>> root;

    public BinaryTree() {
        this.root = null;
    }

    /**
     * Inserta una nueva asociación en el árbol.
     *
     * @param key la clave (palabra en francés)
     * @param value el valor (traducción en español)
     */
    public void insert(K key, V value) {
        Association<K, V> association = new Association<>(key, value);
        root = insert(root, association);
    }

    /**
     * Si el nodo es null, crea un nuevo nodo en ese espacio.
     * Si la clave es menor va a la izquierda, si es mayor va a la derecha.
     *
     * @param node nodo raíz del subárbol actual
     * @param association la asociación a insertar
     * @return el nodo raíz del subárbol modificado
     */
    private BSTNode<Association<K, V>> insert(
            BSTNode<Association<K, V>> node,
            Association<K, V> association) {

        // Caso base: espacio vacío, insertamos aquí
        if (node == null) {
            return new BSTNode<>(association);
        }

        int cmp = association.getKey().compareTo(node.getData().getKey());

        if (cmp < 0) {
            // La clave es menor, continúa por el subárbol izquierdo
            node.setLeft(insert(node.getLeft(), association));
        } else if (cmp > 0) {
            // La clave es mayor, continúa por el subárbol derecho
            node.setRight(insert(node.getRight(), association));
        }

        return node;
    }

    /**
     * Busca una asociación por su clave en el árbol.
     *
     * @param key la clave a buscar (palabra en francés)
     * @return la asociación encontrada, o null si no existe
     */
    public Association<K, V> search(K key) {
        return search(root, key);
    }

    /**
     * Recorre el árbol comparando la clave buscada con cada nodo
     * hasta encontrarla o llegar a un nodo null.
     *
     * @param node el nodo raíz del subárbol actual
     * @param key la clave a buscar
     * @return la asociación encontrada, o null si no existe
     */
    private Association<K, V> search(
            BSTNode<Association<K, V>> node,
            K key) {

        // Caso base: nodo null, la clave no existe en el árbol
        if (node == null) return null;

        int cmp = key.compareTo(node.getData().getKey());

        if (cmp < 0) {
            // La clave buscada es menor, continúa por la izquierda
            return search(node.getLeft(), key);
        } else if (cmp > 0) {
            // La clave buscada es mayor, continúa por la derecha
            return search(node.getRight(), key);
        } else {
            // Clave encontrada
            return node.getData();
        }
    }

    /**
     * Recorre el árbol en in-order y retorna las asociaciones ordenadas
     * alfabéticamente por clave.
     *
     * @return lista ordenada de asociaciones
     */
    public List<Association<K, V>> inOrder() {
        List<Association<K, V>> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    /**
     * Visita los nodos en el orden: izquierda, raíz, derecha.
     *
     * @param node nodo raíz del subárbol actual
     * @param result lista donde se acumulan las asociaciones
     */
    private void inOrder(
            BSTNode<Association<K, V>> node,
            List<Association<K, V>> result) {

        if (node == null) return;

        inOrder(node.getLeft(), result); // izquierda
        result.add(node.getData()); // raíz
        inOrder(node.getRight(), result);// derecha
    }
}
