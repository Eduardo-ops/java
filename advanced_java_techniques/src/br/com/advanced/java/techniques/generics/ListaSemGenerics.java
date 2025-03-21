package br.com.advanced.java.techniques.generics;

import java.util.ArrayList;
import java.util.List;

public class ListaSemGenerics {

    public static void main(String[] args) {

        // Exemplo de uso sem generics
        Lista<Integer> numeros = new Lista<>();
        numeros.adicionar(1);
        numeros.adicionar(2);

        Lista<String> textos = new Lista<>();
        textos.adicionar("Texto 1");
        textos.adicionar("Texto 2");

         /*
            Utilizando cada lista com seu respectivo tipo de objetos.
            Evita que a lista trabalhada no programa, se perca durante o desenvolvimento,
            e venha causar complicações ao longo do código por conta de suas alterações de tipos
            de objetos.
         */
        int numero = (int) numeros.obter(0);
        System.out.println(numero);

        String texto = (String) textos.obter(1);
        System.out.println(texto);
    }

    public static class Lista<T> {

        private List<T> lista = new ArrayList<>();

        public void adicionar(T elemento) {
            lista.add(elemento);
        }

        public T obter(int indice) {
            return lista.get(indice);
        }
    }
}
