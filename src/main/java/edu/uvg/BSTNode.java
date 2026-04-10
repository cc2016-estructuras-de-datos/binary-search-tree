package edu.uvg;

/**
 * Representa un nodo individual dentro del árbol binario de búsqueda.
 * Cada nodo contiene un dato de tipo genérico y referencias a sus hijos
 * izquierdo y derecho.
 *
 * @param <E> el tipo de dato que almacena el nodo
 *
 * @autor Weslly Cabrera
 */
public class BSTNode<E> {

    private E data;
    private BSTNode<E> left;
    private BSTNode<E> right;

    /**
     * Constructor que crea un nodo con un dato y sin hijos.
     * @param data el dato que almacenará el nodo
     */
    public BSTNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Retorna el dato almacenado en el nodo.
    public E getData() {
        return data;
    }

    // Retorna el hijo izquierdo del nodo.
    public BSTNode<E> getLeft() {
        return left;
    }

    // Retorna el hijo derecho del nodo.
    public BSTNode<E> getRight() {
        return right;
    }

    // Asigna el dato del nodo.
    public void setData(E data) {
        this.data = data;
    }

    // Asigna el hijo izquierdo del nodo.
    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    // Asigna el hijo derecho del nodo
    public void setRight(BSTNode<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{data=" + data + "}";
    }
}
