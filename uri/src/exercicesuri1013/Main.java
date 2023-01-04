package exercicesuri1013;

import java.util.Scanner;

/**
 * Fa�a um programa que leia tr�s valores e apresente o maior dos tr�s valores
 * lidos seguido da mensagem �eh o maior�. Utilize a f�rmula:
 * 
 * Obs.: a f�rmula apenas calcula o maior entre os dois primeiros (a e b). Um
 * segundo passo, portanto � necess�rio para chegar no resultado esperado.
 * 
 * ENTRADA 
 * O arquivo de entrada cont�m tr�s valores inteiros.
 * 
 * SA�DA 
 * Imprima o maior dos tr�s valores seguido por um espa�o e a mensagem "eh
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
