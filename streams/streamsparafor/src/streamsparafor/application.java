package streamsparafor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class application {
	public static void main(String[] args) {
		/**
		 * JAVA 8: STREAMS Streams - Fluxo de dados
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

		//Discarta os primeiros 7 elementos da lista É uma operação intermediária.
		listaNumeros.stream().skip(7).forEach(numero -> System.out.println(numero));
		System.out.println("");

		
		//Trabalha somente os 4 primeiros elementos. É uma operação intermediária.
		listaNumeros.stream()
				.limit(4) // Trabalha somente os 4 primeiros elementos.
				.forEach(numero -> System.out.println(numero));
		System.out.println("");

		
		/**
		 * Nâo permite que trabalha elementos repetidos.
		 *
		 * É utilizado o equals e hashCod para comparação, e nesse caso, deve-se conter
		 * esses métodos declarados na classe, para que seja possível utilizar o
		 * distinct.
		 *
		 * É uma operação intermediária.
		 */
		listaNumeros.stream()
				.distinct() // Trabalha somente os 4 primeiros elementos.
				.forEach(numero -> System.out.println(numero));
		System.out.println("");

		listaNumeros.stream().skip(4).distinct().limit(5).forEach(numero -> System.out.println(numero));
		System.out.println("");

		
		// Um método intermediário que permite buscar de forma mais personalizada.
		listaNumeros.stream().filter(numero -> numero % 2 == 0).forEach(numero -> System.out.println(numero));
		System.out.println("");

		
		/**
		 * Modifica a lista, realizando um calculado para cada elemento existente por
		 * 10. Não altera a lista original, é somente alterada no ato de ser utilizada
		 * no stream. É uma operação intermediária.
		 */
		listaNumeros.stream().limit(5)
				.map(numero -> numero * 10)
				.skip(2).distinct()
				.forEach(numero -> System.out.println(numero));

		System.out.println(listaNumeros);
		System.out.println("");

		
		/**
		 * Retorna o total de elementos que foi trabalhado durante o tratamento do
		 * stream.
		 *
		 * É uma operação final.
		 */
		Long count = listaNumeros.stream().filter(numero -> numero % 2 == 0).map(numero -> numero * 10).count();

		System.out.println("Count: " + count);
		System.out.println("");

		
		/**
		 * Retorna o menor valor durante o tratamento do stream.
		 *
		 * É uma operação final.
		 */
		Optional<Integer> menorValor = listaNumeros.stream().filter(numero -> numero % 2 == 0).min(Comparator.naturalOrder());

		System.out.println("Menor valor da lista: " + menorValor.get());
		System.out.println("");

		
		/**
		 * Retorna o maior valor durante o tratamento do stream.
		 *
		 * É uma operação final.
		 */
		Optional<Integer> maximoValor = listaNumeros.stream().filter(numero -> numero % 2 == 0).max(Comparator.naturalOrder());

		System.out.println("Maior valor da lista: " + maximoValor.get());
		System.out.println("");

		
		/**
		 * Retorna uma lista do que foi trabalhado durante o tratamento do stream.
		 *
		 * É uma operação final.
		 */
		List<Integer> novaListaNumeros = listaNumeros.stream().filter(numero -> numero % 2 == 0).collect(Collectors.toList());

		System.out.println("Nova lista: " + novaListaNumeros);
		System.out.println("");

		
		// Agrupar números ímpares e números pares
		Map<Boolean, List<Integer>> mapaImparesPares = listaNumeros.stream().collect(Collectors.groupingBy(numero -> numero % 2 == 0));

		System.out.println("Agrupamento ímpares e pares : " + mapaImparesPares);
		System.out.println("");

		
		// Agrupar números que são divisíveis por três
		Map<Integer, List<Integer>> mapaNumerosDivisiveisTres = listaNumeros.stream().collect(Collectors.groupingBy(numero -> numero % 3));

		System.out.println("Agrupamento números divisíveis por três : " + mapaNumerosDivisiveisTres);
		System.out.println("");

		
		// Concatenar vários valores de string
		String valoresString = listaNumeros.stream().map(numero -> String.valueOf(numero)).collect(Collectors.joining());

		System.out.println("Lista de numeros concatenados : " + valoresString);
		System.out.println("");

		
		// Concatenar vários valores de string entre barras
		String valoresStringEntreBarras = listaNumeros.stream().map(numero -> String.valueOf(numero)).collect(Collectors.joining("/"));

		System.out.println("Lista de numeros concatenados : " + valoresStringEntreBarras);
		System.out.println("");
	}
}
