package lambdastreamsoptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reduce é pegar toda a coleção de dados e transformar em apenas um dado
 * resultado de uma operação;
 */
public class StreamsReduce {
	public static void main(String[] args) throws Exception {
		
		List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5, 6);
		String frase = "Teste para reduce em concatenacao";
		String[] split = frase.split(" ");
		List<String> listaString = Arrays.asList(split);

		// Funções de acumulação e funções associativas;

		// Soma todos os elementos;
		Optional<Integer> reduceSoma = listaInteiros.stream().reduce((n1, n2) -> n1 + n2);
		System.out.println("Soma: " + reduceSoma.get());

		// Multiplica todos os elementos da lista;
		Optional<Integer> reduceMultiplicacao = listaInteiros.stream().reduce((n1, n2) -> n1 * n2);
		System.out.println("Multiplicação: " + reduceMultiplicacao.get());

		// Concatenação de strings
		Optional reduceConcatStrings = listaString.stream().reduce((s1, s2) -> s1.concat(s2));
		System.out.println("Concatenação: " + reduceConcatStrings.get());

		// Funções não associativos com reduce;

		// NÃO FAÇA DESSA FORMA, OPERAÇÃO NÃO ASSOCIATIVA
		Optional<Integer> subtracao = listaInteiros.stream().reduce((n1, n2) -> n1 - n2);
		System.out.println("Subtracao: " + subtracao.get());

		/*
		 * POSSÍVEL SOLUÇÃO; Nesse exemplo, a função parallel agrupa os dados para
		 * chegar no valor exato;
		 */
		Optional<Integer> subtracao2 = listaInteiros.stream().parallel().reduce((n1, n2) -> n1 - n2);

		// Funções reduce com identificação;

		Integer reduceSoma2 = listaInteiros.stream().reduce(0, (n1, n2) -> n1 + n2);
		System.out.println("Soma 2: " + reduceSoma2);

		// Agrupando os dados a serem calculados, semelhante ao parallel;
		Integer reduceSoma3 = listaInteiros.stream().reduce(0, (n1, n2) -> n1 + n2, (n1, n2) -> n1 + n2);
		System.out.println("Soma 3: " + reduceSoma2);

		// Multiplica todos os elementos da lista;
		Integer reduceMultiplicacao2 = listaInteiros.stream().reduce(1, (n1, n2) -> n1 * n2);
		System.out.println("Multiplicação 2: " + reduceMultiplicacao2);

		// Concatenação de strings
		String reduceConcatStrings2 = listaString.stream().reduce("", (s1, s2) -> s1.concat(s2));
		System.out.println("Concatenação2: " + reduceConcatStrings2);

	}
}
