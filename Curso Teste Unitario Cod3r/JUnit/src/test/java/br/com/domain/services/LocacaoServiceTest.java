package br.com.domain.services;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.utils.DataUtils;

public class LocacaoServiceTest {

	/**
	 * Teste com utilizaçao de ferramenta
	 */
	@Test
	public void testeLocacaoService() {
		LocacaoService locacaoService = new LocacaoService();
		boolean result = false;

		// Cenario
		Usuario usuario = new Usuario("Eduardo Isidoro Gonçalves");
		Filme filme = new Filme("Avatar 2", 10, 6.50);

		// Acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		// Validacao
		Assert.assertEquals(6.50, locacao.getValor(), 0.01);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}
