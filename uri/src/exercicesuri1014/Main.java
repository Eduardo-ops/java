package exercicesuri1014;

import java.util.Scanner;

/**
 * Calcule o consumo médio de um automóvel sendo fornecidos a distância total
 * percorrida (em Km) e o total de combustível gasto (em litros).
 * 
 * ENTRADA 
 * O arquivo de entrada contém dois valores: um valor inteiro X
 * representando a distância total percorrida (em Km), e um valor real Y
 * representando o total de combustível gasto, com um dígito após o ponto
 * decimal.
 * 
 * SAÍDA 
 * Apresente o valor que representa o consumo médio do automóvel com 3
 * casas após a vírgula, seguido da mensagem "km/l".
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int totalDistance = sc.nextInt();
		double totalFuel = sc.nextDouble();
		double averageConsumption = totalDistance / totalFuel;

		System.out.println(String.format("%.3f", averageConsumption) + " km/l");
	}

}
