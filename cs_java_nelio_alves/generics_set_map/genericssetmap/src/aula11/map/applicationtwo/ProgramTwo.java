package aula11.map.applicationtwo;

/*
 * Suponhamos que queremos ter uma relação de quantas unidades de cada produto tem nosso estoque.
 * */

import aula11.map.entities.Product;

import java.util.HashMap;
import java.util.Map;

public class ProgramTwo {

    public static void main(String[] args) {

        Map<Product, Double> stock = new HashMap<>();
        int count = 0;

        Product product1 = new Product("Tv", 6700.0);
        Product product2 = new Product("Notebook Dell", 4400.0);
        Product product3 = new Product("Tablet Samsung", 2100.0);

        stock.put(product1, 10000.0);
        stock.put(product2, 20000.0);
        stock.put(product3, 15000.0);

        Product product4 = new Product("Tv", 6700.0);

        /*
         * Aqui ele nos retornará true, pois utilizando o hashcode e equals na entidade, ele consegue encontrar os
         * mesmos valores desse objeto instanciado em um objeto ja existente dentro do map.
         * */
        System.out.println("Contains 'product4' key: " + stock.containsKey(product4));

        if (stock.containsKey(product4)) {
            System.out.println("True!");
        } else {
            System.out.println("False!");
        }

        System.out.println("Produto: " + product1.getName() + " contém ao todo: " + stock.get(product1) + " unidades.");
        System.out.println("Produto: " + product2.getName() + " contém ao todo: " + stock.get(product2) + " unidades.");
        System.out.println("Produto: " + product3.getName() + " contém ao todo: " + stock.get(product3) + " unidades.");
        System.out.println("Produto: " + product4.getName() + " contém ao todo: " + stock.get(product4) + " unidades.");
    }
}
