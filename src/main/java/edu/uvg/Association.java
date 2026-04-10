package edu.uvg;

/**
 * Representa un par clave-valor.
 * La clave es la palabra en francés y el valor es su traducción al español.
 *
 * @param <K> el tipo de la clave (Comparable para permitir el ordenamiento en el BST)
 * @param <V> el tipo del valor
 *
 * @author Weslly Cabrera
 */
public class Association<K extends Comparable<K>, V> {

    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
