package exercicesuri1014;

import java.util.Scanner;

/**
 * Calcule o consumo m�dio de um autom�vel sendo fornecidos a dist�ncia total
 * percorrida (em Km) e o total de combust�vel gasto (em litros).
 * 
 * ENTRADA 
 * O arquivo de entrada cont�m dois valores: um valor inteiro X
 * representando a dist�ncia total percorrida (em Km), e um valor real Y
 * representando o total de combust�vel gasto, com um d�gito ap�s o ponto
 * decimal.
 * 
 * SA�DA 
 * Apresente o valor que representa o consumo m�dio do autom�vel com 3
 * casas ap�s a v�rgula, seguido da mensagem "km/l".
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
