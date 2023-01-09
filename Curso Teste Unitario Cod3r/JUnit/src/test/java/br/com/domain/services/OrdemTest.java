package br.com.domain.services;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * M�todo indicado para tratar a ordem de execu��o de testes, a forma da ordem
 * ser organizada � justamente pela ordem alfab�tica, mesmo assim, �
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
	 * M�todo n�o indicado;
	 */
	@Test
	public void testGeral() {
		inicia();
		verifica();
	}

}
