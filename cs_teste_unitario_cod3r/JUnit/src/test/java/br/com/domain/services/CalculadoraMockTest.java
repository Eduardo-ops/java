package br.com.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import junit.framework.Assert;

public class CalculadoraMockTest {

	@Mock
	private CalculadoraService calcMock;

	@Spy
	private CalculadoraService calcSpy;

	@Mock
	private EmailService email;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void teste() {
		CalculadoraService calc = Mockito.mock(CalculadoraService.class);

		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);

		Assert.assertEquals(5, calc.somar(1, 100000));

		System.out.println(argCapt.getAllValues());
	}

	@Test
	public void testeMostrarDiferencaEntreMockESpy() {
		Mockito.when(calcMock.somar(1, 2)).thenReturn(8);
		Mockito.when(calcSpy.somar(1, 2)).thenReturn(8);

		/*
		 * Quando for chamado o método somar, retorne 8, aqui, o java precisa chamar o
		 * método para gravar a expectativa
		 */
		Mockito.when(calcSpy.somar(1, 2)).thenReturn(8);

		/*
		 * Retorne 5 quando calcular 1 + 2, aqui o java não chamou o método somar para
		 * retornar a expectativa
		 */
		Mockito.doReturn(5).when(calcSpy).somar(1, 2);

		System.out.println("testeMostrarDiferencaEntreMockESpy");
		System.out.println("Mock: " + calcMock.somar(1, 9));
		System.out.println("Spy: " + calcSpy.somar(1, 9));

		/*
		 * Método void com mock, como comportamento padrão, se não tratarmos o retorno,
		 * ele simplesmente não retorna nada do método.
		 */
		System.out.println("Mock:");
		calcMock.imprime();

		/*
		 * Método void com spy, como comportamento padrão, mesmo que não tratamos o
		 * retorno, ele executa o método.
		 */
		System.out.println("Spy:");
		calcSpy.imprime();
	}

	@Test
	public void testeFazerUmaChamadaRealDoMetodoSoma() {
		Mockito.when(calcMock.somar(1, 9)).thenCallRealMethod();

		System.out.println("testeFazerUmaChamadaRealDoMetodoSoma");
		System.out.println("Mock: " + calcMock.somar(1, 9));
		System.out.println("Spy: " + calcSpy.somar(1, 9));
	}

	@Test
	public void testeNaoDeveRetornarValorMetodoVoidComSpy() {
		Mockito.doNothing().when(calcSpy).imprime();

		System.out.println("testeNaoDeveRetornarValorMetodoVoidComSpy");
		System.out.println("Spy");
		calcSpy.imprime();
	}
}
