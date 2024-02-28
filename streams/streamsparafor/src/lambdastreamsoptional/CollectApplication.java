package lambdastreamsoptional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectApplication {
	public static void main(String[] args) {
		List<Integer> listaInteiros = Arrays.asList(1, 2, 3, 4, 5, 6);

		// Fornecedor - acumulação - combinação
		List<Integer> collectInteiros = listaInteiros.stream().collect(() -> new ArrayList<>(),
				(arrayList, e) -> arrayList.add(e), (l1, l2) -> l1.addAll(l2));
		System.out.println("Collect: " + collectInteiros);

		// toList - Armazena o resultado em uma lista.
		List<Integer> listaInteirosPares = listaInteiros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println("Collect com toList: " + listaInteirosPares);

		// toSet
		Set<Integer> listaInteirosPares2 = listaInteiros.stream().filter(n -> n % 2 == 0).collect(Collectors.toSet());
		System.out.println("Collect com toSet: " + listaInteirosPares2);

		// Joins - Concatenando strings.
		String join = listaInteiros.stream().map(n -> n.toString()).collect(Collectors.joining());
		System.out.println("Collect com join(String): " + join);

		String join2 = listaInteiros.stream().map(n -> n.toString()).collect(Collectors.joining("T"));
		System.out.println("Collect com join2: " + join2);

		// averaging
		Double media = listaInteiros.stream().collect(Collectors.averagingInt(n -> n));
		System.out.println("Collect com averaging: " + media);

		// suming
		Integer soma = listaInteiros.stream().collect(Collectors.summingInt(n -> n));
		System.out.println("Collect com suming: " + soma);

		// summarizing
		IntSummaryStatistics intSummaryStatistics = listaInteiros.stream().collect(Collectors.summarizingInt(n -> n));
		System.out.println("Collect com summarizing, média: " + intSummaryStatistics.getAverage());
		System.out.println("Collect com summarizing, contador: " + intSummaryStatistics.getCount());
		System.out.println("Collect com summarizing, maior: " + intSummaryStatistics.getMax());
		System.out.println("Collect com summarizing, menor: " + intSummaryStatistics.getMin());
		System.out.println("Collect com summarizing, soma: " + intSummaryStatistics.getSum());
		
		// count
		Long count = listaInteiros.stream().filter(n -> n % 2 == 0).collect(Collectors.counting());
		System.out.println("Collect com count: " + count);
	}
}
