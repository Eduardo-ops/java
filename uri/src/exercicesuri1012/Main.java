package exercicesuri1012;

import java.util.Scanner;

/**
 * Escreva um programa que leia três valores com ponto flutuante de dupla
 * precisão: A, B e C. Em seguida, calcule e mostre: a) a área do triângulo
 * retângulo que tem A por base e C por altura. b) a área do círculo de raio C.
 * (pi = 3.14159) c) a área do trapézio que tem A e B por bases e C por altura.
 * d) a área do quadrado que tem lado B. e) a área do retângulo que tem lados A
 * e B.
 * 
 * ENTRADA 
 * O arquivo de entrada contém três valores com um dígito após o ponto
 * decimal.
 * 
 * SAÍDA 
 * O arquivo de saída deverá conter 5 linhas de dados. Cada linha
 * corresponde a uma das áreas descritas acima, sempre com mensagem
 * correspondente e um espaço entre os dois pontos e o valor. O valor calculado
 * deve ser apresentado com 3 dígitos após o ponto decimal.
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
