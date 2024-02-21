package lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class application {
    public static void main(String[] args) {

        // JAVA 8: FUNÇÕES LAMBDA

        /**
         * Conceito
         * SAM - Single Abstract Method
         * Qualquer interface que tenha apenas um método abstrato.
         */

        // Ex 1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!!!");
            }
        }).run();

        new Thread(() -> System.out.println("Hello World!!!")).run();

        // Ex 2
        JButton jBUtton1 = new JButton();
        jBUtton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello World!!!");
            }
        });

        JButton jButton2 = new JButton();
        jButton2.addActionListener(e -> System.out.println("Hello World!!!"));

        /**
         * Api de Stream
         * Stream - Fluxo de dados
         */

        // Ex 1
        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4);

        for (Integer numero : listaNumeros) {
            System.out.println(numero);
        }

        //Ex 2
        listaNumeros.stream().forEach(numero -> System.out.println(numero));

        //Ex 3
        listaNumeros.stream()
                .filter(numero -> numero % 2 == 0) // Filtra somente os números que são pares.
                .forEach(numero -> System.out.println(numero)); // Traz somente os números pares calculados pelo filter.
    }
}
