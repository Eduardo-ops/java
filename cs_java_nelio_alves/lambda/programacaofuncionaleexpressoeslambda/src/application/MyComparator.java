package application;

import entities.Product;

import java.util.Comparator;

/*
 * Boas práticas na utilização de uma classe exclusiva para tratar a ordenação
 * de uma lista, ao invés de tratar exclusivamente na classe do objeto a ser
 * trabalhado.
 * */
public class MyComparator implements Comparator<Product> {

    /*
     * Realiza comparação com os nomes, ignorando letras maiúsculas e minúsculas.
     * toUppercase converte a sequência para letras maiúsculas.
     * O resultado de uma lista desse tipo de objeto será em ordem alfabética.
     * */
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
}
