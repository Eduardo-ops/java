package br.com.domain.services;

import static br.com.domain.utils.DataUtils.isMesmaData;
import static br.com.domain.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.Is;
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

		// Validacao modo 1
		Assert.assertEquals(6.50, locacao.getValor(), 0.01);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

		// Validacao modo 2 - Fluent Interface
		assertThat(locacao.getValor(), is(equalTo(6.50)));
		assertThat(locacao.getValor(), is(not(6.0)));
		assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}
}
