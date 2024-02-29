package lambdastreamsoptional;

import java.util.stream.IntStream;

/**
 * JAVA 8 - Funções Lambda - Tipos
 */
public class LambdaApplication2 {
	public static void main(String[] args) {
		
		// Parênteses.
		
		// Forma mais simples de implementar um lambda.
		IntStream.range(0, 5).filter(n -> n % 2 == 0).forEach(System.out::println);
		
		// Forma que obriga a implementar o lambda com parênteses.
		IntStream.range(0, 5).filter((int numero) -> numero % 2 == 0).forEach(System.out::println);
		
		IntStream.range(0, 5).filter((int n) -> n % 2 == 0).reduce((int n1, int n2) -> n1 + n2).ifPresent(System.out::println);
		
		// Chaves
		
		IntStream.range(0, 5).filter((int n) -> {
			System.out.println("Entrou nas chaves");
			return n % 2 == 0;
		}).forEach(System.out::println);
	}
}
