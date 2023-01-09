package br.com.domain.services;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Método indicado para tratar a ordem de execução de testes, a forma da ordem
 * ser organizada é justamente pela ordem alfabética, mesmo assim, é
 * interessante permanecer com os testes independentes;
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {

	public static int contador = 0;

	@Test
	public void inicia() {
		contador = 1;
	}

	@Test
	public void verifica() {
		Assert.assertEquals(contador, 1);
	}

	/**
	 * Método não indicado;
	 */
	@Test
	public void testGeral() {
		inicia();
		verifica();
	}

}
