package exercicesuri1013;

import java.util.Scanner;

/**
 * Faça um programa que leia três valores e apresente o maior dos três valores
 * lidos seguido da mensagem “eh o maior”. Utilize a fórmula:
 * 
 * Obs.: a fórmula apenas calcula o maior entre os dois primeiros (a e b). Um
 * segundo passo, portanto é necessário para chegar no resultado esperado.
 * 
 * ENTRADA 
 * O arquivo de entrada contém três valores inteiros.
 * 
 * SAÍDA 
 * Imprima o maior dos três valores seguido por um espaço e a mensagem "eh
 * o maior".
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int biggerResultAB = (a + b + Math.abs(a - b)) / 2;
		int biggerResultBC = (b + c + Math.abs(b - c)) / 2;

		if (biggerResultAB > biggerResultBC) {
			System.out.println(biggerResultAB + " eh o maior");
		} else {
			System.out.println(biggerResultBC + " eh o maior");
		}
	}

}
