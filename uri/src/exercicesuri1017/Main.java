package exercicesuri1017;

import java.util.Scanner;

/**
 * Joaozinho quer calcular e mostrar a quantidade de litros de combust�vel
 * gastos em uma viagem, ao utilizar um autom�vel que faz 12 KM/L. Para isso,
 * ele gostaria que voc� o auxiliasse atrav�s de um simples programa. Para
 * efetuar o c�lculo, deve-se fornecer o tempo gasto na viagem (em horas) e a
 * velocidade m�dia durante a mesma (em km/h). Assim, pode-se obter dist�ncia
 * percorrida e, em seguida, calcular quantos litros seriam necess�rios. Mostre
 * o valor com 3 casas decimais ap�s o ponto.
 * 
 * ENTRADA 
 * O arquivo de entrada cont�m dois inteiros. O primeiro � o tempo gasto
 * na viagem (em horas) e o segundo � a velocidade m�dia durante a mesma (em
 * km/h).
 * 
 * SA�DA 
 * Imprima a quantidade de litros necess�ria para realizar a viagem, com
 * tr�s d�gitos ap�s o ponto decimal
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
