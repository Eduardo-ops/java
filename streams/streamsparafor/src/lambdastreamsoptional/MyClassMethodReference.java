package lambdastreamsoptional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * JAVA 8 - Method Reference.
 * Method reference é mais uma forma que podemos usar para escrever expressões lambdas.
 */
public class MyClassMethodReference {
	public static void main(String[] args) {

		List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5);

		// Sem method reference.
		System.out.println("Exemplo sem method reference:");
		listaInteiros.stream().forEach((n) -> System.out.println(n));
		System.out.println("");
		
		// Method reference.
		System.out.println("Exemplo com method reference:");
		listaInteiros.stream().forEach(System.out::println);
		System.out.println("");

		// Métodos estáticos.
		listaInteiros.stream().map((n) -> multiplicaPorDois(n)).forEach(System.out::println);
		System.out.println("");

		listaInteiros.stream().map(MyClassMethodReference::multiplicaPorDois).forEach(System.out::println);
		System.out.println("");

		// Construtores.
		listaInteiros.stream().map((n) -> new BigDecimal(n)).forEach(System.out::println);
		System.out.println("");

		listaInteiros.stream().map(BigDecimal::new).forEach(System.out::println);
		System.out.println("");

		// Várias instâncias.
		listaInteiros.stream().map((n) -> n.doubleValue()).forEach(System.out::println);
		System.out.println("");

		listaInteiros.stream().map(Integer::doubleValue).forEach(System.out::println);

		// Instância única.
		BigDecimal b1 = BigDecimal.TEN;
		listaInteiros.stream().map(BigDecimal::new).map((b) -> b.multiply(b1)).forEach(System.out::println);
		System.out.println("");

		listaInteiros.stream().map(BigDecimal::new).map(b1::multiply).forEach(System.out::println);
		System.out.println("");
	}

	private static Integer multiplicaPorDois(Integer numero) {
		return numero * 2;
	}
}
