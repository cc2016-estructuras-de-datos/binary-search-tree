package edu.uvg;

public class Main {

    public static void main(String[] args) {

        BSTDictionary dictionary = new BSTDictionary();

        //Cargar el diccionario desde el archivo
        System.out.println("Cargando diccionario");
        dictionary.loadFromFile("data/diccionario.txt");

        //Imprimir el diccionario en orden (in-order)
        System.out.println("\nDiccionario en orden alfabético (francés):");
        dictionary.printInOrder();

        //Traducir el archivo de texto
        System.out.println("\nTraducción del texto:");
        dictionary.translateFile("data/texto.txt");
    }
}