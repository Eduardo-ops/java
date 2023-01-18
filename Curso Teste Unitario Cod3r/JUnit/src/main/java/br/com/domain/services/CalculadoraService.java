package br.com.domain.services;

import br.com.domain.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraService {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int multiplicar(int a, int b) {
		return a * b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirPorZeroException {
		if (b == 0) {
			throw new NaoPodeDividirPorZeroException();
		}

		return a / b;
	}

}
