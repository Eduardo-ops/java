package application;

/*
 * Trabalhando com ordenação de lista.
 * Suponha que uma classe Product com os atributos name e price.
 *
 * Podemos implementar a comparação de produtos por meio da implementação da interface Comparable<Product>
 *
 * Entretanto, desta forma nossa classe não fica fechada para alteração: se o critério de comparação mudar,
 * precisaremos alterar a classe Product.
 *
 * Podemos então usar o default method "sort" da interface List:
 * default void sort(Comparator < ? super E > c)
 * */

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 6900.00));
        list.add(new Product("Notebook", 4200.00));
        list.add(new Product("Tablet", 1600.00));

        /* 1° Método - Comparator implementado na classe do Product.
        Utilizando o collection para realizar a ordem, junto a classe product
        com o método compareTo da interface Comparable.
        Collections.sort(list);*/

        /* 2° Método - Comparator objeto de classe separada.
         Chamando o sor diretamente da lista de objeto.
        list.sort(new MyComparator());*/

        /* 3° Método - Comparator diretamente na classe lógica do negócio.
         Trabalhando diretamente com um objeto de comparator na lógica.
         Porém é uma forma muito verbosa e trabalhosa de se fazer.
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            }
        };

        list.sort(comparator);*/

        /* 4° Método - Comparator objeto de expressão lambda com chaves.
         Utilizando função anônima(aero function / Lambda)
        Comparator<Product> comparator = (p1, p2) -> {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        };

        list.sort(comparator);*/

        /* 5° Método - Comparator objeto de expressão lambda sem chaves.
        Definindo o comparator em apenas uma linha.
        Comparator<Product> comparator = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        list.sort(comparator);*/

        /*
         * 6° Método = Comparator objeto diretamente no argumento de sort.
         * Trabalhando com Comparator em forma de função anônima(aero function / Lambda) diretamente no método sort.
         * */
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
