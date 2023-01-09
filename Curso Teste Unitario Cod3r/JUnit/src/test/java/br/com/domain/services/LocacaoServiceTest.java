package br.com.domain.services;

import static br.com.domain.utils.DataUtils.isMesmaData;
import static br.com.domain.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.exceptions.FilmeSemEstoqueException;
import br.com.domain.exceptions.LocadoraException;
import br.com.domain.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService locacaoService;

	@Rule
	public ErrorCollector errors = new ErrorCollector();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setup() {
		System.out.println("Before");
		locacaoService = new LocacaoService();
	}

	@After
	public void tearDown() {
		System.out.println("After");
	}

	@BeforeClass
	public static void setupClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("After Class");
	}

	/**
	 * Teste com utilizaçao de ferramenta
	 */
	@Test
	public void testeLocacao() throws Exception {
		// Cenario
		Usuario usuario = new Usuario("Eduardo Isidoro Gonçalves");
		Filme filme = new Filme("Avatar 2", 10, 6.50);

		// Acao
		Locacao locacao;
		try {
			locacao = locacaoService.alugarFilme(usuario, filme);

			// Validacao modo 1
			Assert.assertEquals(6.50, locacao.getValor(), 0.01);
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

			// Validacao modo 2 - Fluent Interface
			assertThat(locacao.getValor(), is(equalTo(6.50)));
			assertThat(locacao.getValor(), is(not(6.0)));
			assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Teste com utilizaçao ErrorCollector, onde nos possibilita verificar todos os
	 * possíveis erros.
	 * 
	 * Utilizando também o lançamento de exceção, onde faz com que o JUnit faz todo
	 * o tratamento da exceção
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeLocacaoComErrorCollector() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 2, 6.50);

		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		errors.checkThat(locacao.getValor(), is(equalTo(6.50)));
		errors.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		errors.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}

	/**
	 * Teste passando uma exception na anotação, onde o teste vai ser validado se
	 * realmente for lançado a exceção esperada e somente deve ser usado quando
	 * realmente tiver certeza do retorno da exceção esperada, uma forma mais
	 * elegante
	 * 
	 * JUnit faz todo tratamento de exceção.
	 * 
	 * @throws Exception
	 */
	@Test(expected = FilmeSemEstoqueException.class)
	public void testeLocacaoFilmeSemEstoque() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 0, 6.50);

		locacaoService.alugarFilme(usuario, filme);
	}

	/**
	 * Mesma finalidade do método testeLocacaoFilmeSemEstoque, porém aqui tratamos a
	 * exceção de forma mais clara no próprio código, uma forma mais robusta.
	 * 
	 * Instrutor recomenda usar essa forma, pelo fato de ser mais completa, ou seja,
	 * robusta.
	 * 
	 * @throws LocadoraException
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeLocacaoFilmeSemEstoque2() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 0, 6.50);

		try {
			locacaoService.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lançado uma exceção");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque"));
		}
	}

	/**
	 * Teste utilizando ExpectedException, onde dizemos qual exceção é esperada a
	 * ser lançada e qual o tipo de mensagem de retorno
	 * 
	 * JUnit faz todo tratamento de exceção.
	 * 
	 * @throws FilmeSemEstoqueException
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeLocacaoFilmeSemEstoque3() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 0, 6.50);

		expectedException.expect(Exception.class);
		expectedException.expectMessage("Filme sem estoque");

		locacaoService.alugarFilme(usuario, filme);
	}

	/**
	 * Essa é a forma mais pratica de se usar a forma elegante, porém, quando se
	 * passa a própria exception customizada no programa, e não uma simples
	 * exception genérica
	 * 
	 * Teste passando uma exception na anotação, onde o teste vai ser validado se
	 * realmente for lançado a exceção esperada.
	 * 
	 * JUnit faz todo tratamento de exceção.
	 * 
	 * @throws Exception
	 */
	@Test(expected = FilmeSemEstoqueException.class)
	public void testeLocacaoFilmeSemEstoque4() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		Filme filme = new Filme("Batman Begins", 0, 6.50);

		locacaoService.alugarFilme(usuario, filme);
	}

	/**
	 * Teste que faz a validação de usuário com base na forma robusta
	 * 
	 * * Instrutor recomenda usar essa forma, pelo fato de ser mais completa, ou
	 * seja, robusta.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeLocacaoSemUsuario() throws FilmeSemEstoqueException {
		Filme filme = new Filme("Batman Begins", 9, 6.50);

		try {
			locacaoService.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuário obrigatório"));
		}
	}

	/**
	 * Teste que faz a validação de filme com base na forma nova
	 * 
	 * @throws Exception
	 */
	@Test()
	public void testeLocadoraSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");

		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Filme obrigatório");

		locacaoService.alugarFilme(usuario, null);

	}
}
