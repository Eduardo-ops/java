package lambdastreamsoptional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/*
 * Para de retornar NULL e economize condicionais if e else por Optional.
 * Optinal foi desenvolvido para retorno de método.
 * Não é recomendado receber Optional por parâmetro em métodos.
 */
public class OptionalApplication {
	public static void main(String[] args) throws Exception {
		String numero = "10";

		// 1 Converter um número em caractere para um Integer, sem tratamento para valores nulos.
		Integer numeroConvertido1 = converterEmNumero(numero);
		System.out.println("1: " + numeroConvertido1);

		// 2 Conversão de caractere numérico para Integer com tratamento de valores nulos com Optional.
		converterParaNumero(numero).ifPresent(n -> System.out.println("2: " + n));

		// 3 Caso o valor seja nulo ou vazio, o Optional vai retornar um valor padrão definido pelo programa.
		Integer numeroConvertido3 = converterParaNumero(null).orElse(20);
		System.out.println("3: " + numeroConvertido3);

		// 4 Caso o valor seja vazio ou nulo, é possível realizar outros cálculos através de lambda com o orElseGet.
		Integer numeroConvertido4 = converterParaNumero("").orElseGet(() -> {
			return multiplicaNumero(numero, 10);
		});
		System.out.println("4: " + numeroConvertido4);

		/*
		 * 5 Stream, encontra o primeiro elemento, e se ele for presente, imprima o
		 * mesmo no console;
		 */
		Stream.of("7", "2", "9").findFirst().ifPresent(n -> System.out.println("5: " + n));

		// 6 Convertendo com Optional do tipo primitivo.
		int numeroPrimitivoConvertido = converterParaNumeroPrimitivo(numero).orElseThrow(() -> new Exception("Erro na conversão."));
		System.out.println("6: " + numeroPrimitivoConvertido);

		// 7 Caso o valor seja nulo ou vazio, é retornado um exception.
		Integer numeroConvertido5 = converterParaNumero("").orElseThrow(() -> new Exception(
				"7: Ocorreu um erro na conversão do caractere para valor numérico. Método converterParaNumero()"));
	}

	public static Integer converterEmNumero(String numeroString) {
		return Integer.valueOf(numeroString);
	}

	public static Optional<Integer> converterParaNumero(String numeroString) {
		try {
			Integer numeroConvertido = Integer.valueOf(numeroString);
			return Optional.of(numeroConvertido);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public static Integer multiplicaNumero(String numeroString, Integer numeroMultiplicador) {
		return Integer.valueOf(numeroString) * numeroMultiplicador;
	}

	public static OptionalInt converterParaNumeroPrimitivo(String numeroString) {
		try {
			int numeroConvertido = Integer.parseInt(numeroString);
			return OptionalInt.of(numeroConvertido);
		} catch (Exception e) {
			return OptionalInt.empty();
		}

	}
}
