package exercicesuri1009;

import java.util.Scanner;

/**
 * Fa�a um programa que leia o nome de um vendedor, o seu sal�rio fixo e o total
 * de vendas efetuadas por ele no m�s (em dinheiro). Sabendo que este vendedor
 * ganha 15% de comiss�o sobre suas vendas efetuadas, informar o total a receber
 * no final do m�s, com duas casas decimais.
 * 
 * ENTRADA
 * O arquivo de entrada cont�m um texto (primeiro nome do vendedor) e 2 valores
 * de dupla precis�o (double) com duas casas decimais, representando o sal�rio
 * fixo do vendedor e montante total das vendas efetuadas por este vendedor,
 * respectivamente.
 * 
 * SA�DA
 * Imprima o total que o funcion�rio dever� receber, conforme exemplo fornecido.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sellerName = sc.next();
		double salary = sc.nextDouble();
		double totalSales = sc.nextDouble();

		salary = salary + (totalSales * 0.15);
		System.out.println(String.format("TOTAL = R$ %.2f", salary));
	}

}
