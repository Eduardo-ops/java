package exercicesuri1010;

import java.util.Scanner;

/**
 * Neste problema, deve-se ler o código de uma peça 1, o número de peças 1, o
 * valor unitário de cada peça 1, o código de uma peça 2, o número de peças 2 e
 * o valor unitário de cada peça 2. Após, calcule e mostre o valor a ser pago.
 * 
 * ENTRADA 
 * O arquivo de entrada contém duas linhas de dados. Em cada linha
 * haverá 3 valores, respectivamente dois inteiros e um valor com 2 casas
 * decimais.
 * 
 * SAÍDA 
 * A saída deverá ser uma mensagem conforme o exemplo fornecido abaixo,
 * lembrando de deixar um espaço após os dois pontos e um espaço após o "R$". O
 * valor deverá ser apresentado com 2 casas após o ponto.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int codPice1 = sc.nextInt();
		int qtdPices1 = sc.nextInt();
		double unitaryValuePice1 = sc.nextDouble();
		int codPice2 = sc.nextInt();
		int qtdPices2 = sc.nextInt();
		double unitaryValuePice2 = sc.nextDouble();

		double totalSalles = (qtdPices1 * unitaryValuePice1) + (qtdPices2 * unitaryValuePice2);

		System.out.println(String.format("VALOR A PAGAR: R$ %.2f", totalSalles));
	}

}
