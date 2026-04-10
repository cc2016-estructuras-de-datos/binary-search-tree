# Diccionario Francés-Español con BST

Implementación de un diccionario Francés-Español utilizando un Árbol Binario de Búsqueda (BST).
Proyecto desarrollado para el curso de Algoritmos y Estructura de Datos, Universidad del Valle de Guatemala.

---

## Compilación y Ejecución

### Requisitos
- Java 17 o superior
- Gradle 8.x

### Compilar
```bash
./gradlew build
```

### Ejecutar el programa principal
```bash
./gradlew run
```

### Ejecutar el profiling
```bash
./gradlew runProfiling
```

### Ejecutar los tests
```bash
./gradlew test
```

---

## Descripción

El programa implementa un diccionario Francés-Español basado en un BST.
Lee un archivo de asociaciones, las organiza en el árbol y traduce
un texto en francés al español palabra por palabra.

---

## Estructura del Proyecto

```
hw07-bst-dictionary/
│
├── build.gradle
├── settings.gradle
├── README.md
│
├── data/
│   ├── diccionario.txt        ← pares (frances, español)
│   └── texto.txt              ← texto en francés a traducir
│
└── src/
    ├── main/
    │   └── java/
    │       └── edu/
    │           └── uvg/
    │               ├── Main.java
    │               ├── Profiling.java
    │               ├── Association.java
    │               ├── BSTNode.java
    │               ├── BinaryTree.java
    │               └── BSTDictionary.java
    │
    └── test/
        └── java/
            └── edu/
                └── uvg/
                    ├── BSTTest.java
                    └── AssociationTest.java
```

---

## Archivos de Datos

### `data/diccionario.txt`
Cada línea debe tener el formato `(frances, español)`. Por ejemplo:
```
(oui, si)
(maison, casa)
(devoirs, tarea)
(femme, mujer)
(chien, perro)
(ville, pueblo)
```

### `data/texto.txt`
Texto en francés a traducir. Por ejemplo:
```
La femme me a demandé de faire mes devoirs sur ma ville
```

---

## Clases Principales

**`Association<K, V>`**
Contenedor genérico de par clave-valor. Representa una entrada del diccionario
donde la clave es la palabra en francés y el valor es su traducción al español.

**`BSTNode<E>`**
Nodo interno del árbol. Almacena el dato y las referencias a sus hijos
izquierdo y derecho.

**`BinaryTree<K, V>`**
Implementación del Árbol Binario de Búsqueda. Contiene los métodos
`insert()`, `search()` e `inOrder()`.

**`BSTDictionary`**
Capa que envuelve el árbol y expone la lógica del diccionario: carga el
archivo, traduce palabras y muestra el recorrido in-order.

**`Main`**
Punto de entrada del programa. Orquesta la carga del diccionario,
el recorrido in-order y la traducción del texto.

**`Profiling`**
Mide el tiempo de ejecución de `insert()` y `search()` con 100,000 elementos
para analizar el comportamiento del árbol.

---

## Ejemplo de Salida

### Programa principal
```
Cargando diccionario

Diccionario en orden alfabético (francés):
(chien, perro) (devoirs, tarea) (femme, mujer) (maison, casa) (oui, si) (ville, pueblo)

Traducción del texto:
*La* mujer *me* *a* *demandé* *de* *faire* *mes* tarea *sur* *ma* pueblo
```

### Profiling
```
=== Profiling de insert() ===
Insertando 100000 elementos...
Tiempo total de inserción: 134 ms
Tiempo promedio por insert: 1345 ns

=== Profiling de search() ===
Buscando 100000 elementos...
Tiempo total de búsqueda: 89 ms
Tiempo promedio por search: 893 ns

=== Resumen ===
Elementos procesados: 100000
Insert total: 134 ms
Search total: 89 ms
```

---

## Tests

Las pruebas unitarias cubren los métodos `insert()` y `search()` de `BinaryTree`,
verificando inserción simple, inserción múltiple, búsqueda exitosa, búsqueda
fallida y búsqueda en árbol vacío.

Para correr los tests:
```bash
./gradlew test
```