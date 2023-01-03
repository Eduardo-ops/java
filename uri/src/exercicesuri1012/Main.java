package exercicesuri1012;

import java.util.Scanner;

/**
 * Escreva um programa que leia tr�s valores com ponto flutuante de dupla
 * precis�o: A, B e C. Em seguida, calcule e mostre: a) a �rea do tri�ngulo
 * ret�ngulo que tem A por base e C por altura. b) a �rea do c�rculo de raio C.
 * (pi = 3.14159) c) a �rea do trap�zio que tem A e B por bases e C por altura.
 * d) a �rea do quadrado que tem lado B. e) a �rea do ret�ngulo que tem lados A
 * e B.
 * 
 * ENTRADA 
 * O arquivo de entrada cont�m tr�s valores com um d�gito ap�s o ponto
 * decimal.
 * 
 * SA�DA 
 * O arquivo de sa�da dever� conter 5 linhas de dados. Cada linha
 * corresponde a uma das �reas descritas acima, sempre com mensagem
 * correspondente e um espa�o entre os dois pontos e o valor. O valor calculado
 * deve ser apresentado com 3 d�gitos ap�s o ponto decimal.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double C = sc.nextDouble();

		double triangleArea = (A * C) / 2;
		double circule = 3.14159 * Math.pow(C, 2);
		double trapeze = (A + B) * C / 2;
		double squareArea = Math.pow(B, 2);
		double retangle = A * B;

		System.out.println(String.format("TRIANGULO: %.3f", triangleArea));
		System.out.println(String.format("CIRCULO: %.3f", circule));
		System.out.println(String.format("TRAPEZIO: %.3f", trapeze));
		System.out.println(String.format("QUADRADO: %.3f", squareArea));
		System.out.println(String.format("RETANGULO: %.3f", retangle));
	}

}
