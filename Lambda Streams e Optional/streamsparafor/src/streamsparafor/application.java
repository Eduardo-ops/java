package streamsparafor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class application {
    public static void main(String[] args) {
        /**
         * JAVA 8: STREAMS
         * Streams - Fluxo de dados
         */

        List<Integer> listaNumeros = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);

        // JAVA 5
        System.out.println("JAVA 5");
        for (Integer numero : listaNumeros) {
            System.out.println(numero);
        }
        System.out.println("");

        // JAVA 8
        System.out.println("JAVA 8");
        listaNumeros.stream().forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                /**
                 * Discarta os primeiros 7 elementos da lista
                 * É uma operação intermediária.
                 */
                .skip(7)
                .forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                /**
                 * Trabalha somente os 4 primeiros elementos.
                 * É uma operação intermediária.
                 */
                .limit(4) // Trabalha somente os 4 primeiros elementos.
                .forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                /**
                 * Nâo permite que trabalha elementos repetidos.
                 *
                 * É utilizado o equals e hashCod para comparação, e nesse caso,
                 * deve-se conter esses métodos declarados na classe,
                 * para que seja possível utilizar o distinct.
                 *
                 * É uma operação intermediária.
                 */
                .distinct() // Trabalha somente os 4 primeiros elementos.
                .forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                .skip(4)
                .distinct()
                .limit(5)
                .forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                // Uma método intermediário que permite buscar de forma mais personalizada.
                .filter(numero -> numero % 2 == 0)
                .forEach(numero -> System.out.println(numero));
        System.out.println("");

        listaNumeros.stream()
                .limit(5)
                /**
                 * Modifica a lista, realizando um calculado para cada elemento existente por 10.
                 * Não altera a lista original, é somente alterada no ato de ser utilizada no stream.
                 * É uma operação intermediária.
                 */
                .map(numero -> numero * 10)
                .skip(2)
                .distinct()
                .forEach(numero -> System.out.println(numero));

        System.out.println(listaNumeros);
        System.out.println("");

        Long count = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 10)
                /**
                 * Retorna o total de elementos que foi trabalhado durante o tratamento do stream.
                 *
                 * É uma operação final.
                 */
                .count();

        System.out.println("Count: " + count);
        System.out.println("");

        Optional<Integer> menorValor = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                /**
                 * Retorna o menor valor durante o tratamento do stream.
                 *
                 * É uma operação final.
                 */
                .min(Comparator.naturalOrder());

        System.out.println("Menor valor da lista: " + menorValor.get());
        System.out.println("");

        Optional<Integer> maximoValor = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                /**
                 * Retorna o maior valor durante o tratamento do stream.
                 *
                 * É uma operação final.
                 */
                .max(Comparator.naturalOrder());

        System.out.println("Maior valor da lista: " + maximoValor.get());
        System.out.println("");

        List<Integer> novaListaNumeros = listaNumeros.stream()
                .filter(numero -> numero % 2 == 0)
                /**
                 * Retorna uma lista do que foi trabalhado durante o tratamento do stream.
                 *
                 * É uma operação final.
                 */
                .collect(Collectors.toList());

        System.out.println("Nova lista: " + novaListaNumeros);
        System.out.println("");
    }
}
