package br.com.domain.services;

import org.junit.Before;
import org.junit.Test;

import br.com.domain.exceptions.NaoPodeDividirPorZeroException;
import junit.framework.Assert;

public class CalculadoraTest {

	private static CalculadoraService calculadora;

	@Before
	public void setup() {
		calculadora = new CalculadoraService();
	}

	@Test
	public void testeSomarDoisValores() {
		// Cenario
		int a = 5;
		int b = 10;

		// Acao
		int resultado = calculadora.somar(a, b);

		// Validacao
		Assert.assertEquals(15, resultado);
	}

	@Test
	public void testeSubtrairDoisValores() {
		int a = 5;
		int b = 10;

		int resultado = calculadora.subtrair(a, b);

		Assert.assertEquals(-5, resultado);
	}

	@Test
	public void testeMultiplicacaoDoisValores() {
		int a = 5;
		int b = 10;

		int resultado = calculadora.multiplicar(a, b);

		Assert.assertEquals(50, resultado);
	}

	@Test
	public void testeDividirDoisValores() throws NaoPodeDividirPorZeroException {
		int a = 10;
		int b = 5;

		int resultado = calculadora.dividir(a, b);

		Assert.assertEquals(2, resultado);
	}

	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void lancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		int a = 10;
		int b = 0;

		calculadora.dividir(a, b);
	}
}
