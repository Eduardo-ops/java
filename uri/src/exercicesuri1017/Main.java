package exercicesuri1017;

import java.util.Scanner;

/**
 * Joaozinho quer calcular e mostrar a quantidade de litros de combustível
 * gastos em uma viagem, ao utilizar um automóvel que faz 12 KM/L. Para isso,
 * ele gostaria que você o auxiliasse através de um simples programa. Para
 * efetuar o cálculo, deve-se fornecer o tempo gasto na viagem (em horas) e a
 * velocidade média durante a mesma (em km/h). Assim, pode-se obter distância
 * percorrida e, em seguida, calcular quantos litros seriam necessários. Mostre
 * o valor com 3 casas decimais após o ponto.
 * 
 * ENTRADA 
 * O arquivo de entrada contém dois inteiros. O primeiro é o tempo gasto
 * na viagem (em horas) e o segundo é a velocidade média durante a mesma (em
 * km/h).
 * 
 * SAÍDA 
 * Imprima a quantidade de litros necessária para realizar a viagem, com
 * três dígitos após o ponto decimal
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int time = sc.nextInt();
		int averageSpeed = sc.nextInt();
		double km = time * averageSpeed;
		double qtdLiters = (km / 12);

		System.out.println(String.format("%.3f", qtdLiters));
	}

}
