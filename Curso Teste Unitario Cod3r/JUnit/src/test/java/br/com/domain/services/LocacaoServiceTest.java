package br.com.domain.services;

import static br.com.domain.utils.DataUtils.isMesmaData;
import static br.com.domain.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.utils.DataUtils;

public class LocacaoServiceTest {

	@Rule
	public ErrorCollector errors = new ErrorCollector();

	/**
	 * Teste com utilizaçao de ferramenta
	 */
	@Test
	public void testeLocacao() {
		LocacaoService locacaoService = new LocacaoService();

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

	/**
	 * Teste com utilizaçao ErrorCollector, onde nos possibilita verificar todos os
	 * possíveis erros.
	 */
	@Test
	public void testeLocacaoComErrorCollector() {
		LocacaoService locacaoService = new LocacaoService();

		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 6, 6.50);

		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		errors.checkThat(locacao.getValor(), is(equalTo(4.79)));
		errors.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		errors.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(false));

	}
}
