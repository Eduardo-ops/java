package br.com.advanced.java.techniques.generics;

public class ArrayUtilsSemGenerics {

    public void main(String[] args) {
        // Array de Object
        Integer[] integers = {1, 2, 3, 4};
        String[] strings = {"Texto 1", "Texto 2", "Texto 3"};

        // Chamada do método
        Integer primeiroObjeto = getElemento(integers, 0);
        System.out.println("Primeiro objeto: " + primeiroObjeto);

        // Tentativa de armazenar o resultado em uma String (ClassCastException)
        String primeiraString = getElemento(strings, 0);
        System.out.println(primeiraString);
    }

    /*
        Método que retorna o primeiro elemento de um array de Object

        Essa forma de método generic, garante que o desenvolvedor desavisado,
        utilize sempre o mesmo tipo de lista ao longo do código,
        sem correr o risco de tentar utilizar um tipo de objeto diferente.
    */
    public static <T> T getElemento(T[] array, int index) {
        if (index >= array.length || index < 0) {
            return null;
        }
        return array[index];
    }
}
