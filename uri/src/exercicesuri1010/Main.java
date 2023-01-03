package exercicesuri1010;

import java.util.Scanner;

/**
 * Neste problema, deve-se ler o c�digo de uma pe�a 1, o n�mero de pe�as 1, o
 * valor unit�rio de cada pe�a 1, o c�digo de uma pe�a 2, o n�mero de pe�as 2 e
 * o valor unit�rio de cada pe�a 2. Ap�s, calcule e mostre o valor a ser pago.
 * 
 * ENTRADA 
 * O arquivo de entrada cont�m duas linhas de dados. Em cada linha
 * haver� 3 valores, respectivamente dois inteiros e um valor com 2 casas
 * decimais.
 * 
 * SA�DA 
 * A sa�da dever� ser uma mensagem conforme o exemplo fornecido abaixo,
 * lembrando de deixar um espa�o ap�s os dois pontos e um espa�o ap�s o "R$". O
 * valor dever� ser apresentado com 2 casas ap�s o ponto.
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
