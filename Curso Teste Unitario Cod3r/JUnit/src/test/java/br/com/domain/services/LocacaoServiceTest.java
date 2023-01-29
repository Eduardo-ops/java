package br.com.domain.services;

import static br.com.domain.matchers.MatchersProprios.caiEm;
import static br.com.domain.matchers.MatchersProprios.caiNumaSegunda;
import static br.com.domain.matchers.MatchersProprios.eHoje;
import static br.com.domain.matchers.MatchersProprios.eHojeComDiferencaDias;
import static br.com.domain.utils.DataUtils.isMesmaData;
import static br.com.domain.utils.DataUtils.obterDataComDiferencaDias;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
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
import br.com.domain.matchers.DiaSemanaMatcher;
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
	 * Teste com utilizaï¿½ao de ferramenta
	 */
	@Test
	public void testeDeveAlugarFilme() throws Exception {
		// Garante que vai ser executado em dias diferentes que sÃ¡bado
		Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		// Cenario
		Usuario usuario = new Usuario("Eduardo Isidoro Gonï¿½alves");
		List<Filme> listFilmes = new ArrayList<Filme>();

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));

		// Acao
		Locacao locacao;

		try {
			locacao = locacaoService.alugarFilme(usuario, listFilmes);

			// Validacao modo 1
			Assert.assertEquals(13, locacao.getValor(), 0.01);
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));

			// Validacao modo 2 - Fluent Interface
			assertThat(locacao.getValor(), is(equalTo(13.0)));
			//assertThat(locacao.getValor(), is(no));
			assertThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			assertThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));

			// Validação modo - errors
			errors.checkThat(locacao.getValor(), is(equalTo(13.0)));
			errors.checkThat(locacao.getDataLocacao(), eHoje());
			errors.checkThat(locacao.getDataLocacao(), eHojeComDiferencaDias(1));

			// Validacao modo matcher próprios
			errors.checkThat(locacao.getValor(), is(equalTo(13.0)));
			errors.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
			errors.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Teste com utilizaï¿½ao ErrorCollector, onde nos possibilita verificar todos
	 * os possï¿½veis erros.
	 * 
	 * Utilizando tambï¿½m o lanï¿½amento de exceï¿½ï¿½o, onde faz com que o JUnit
	 * faz todo o tratamento da exceï¿½ï¿½o
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeDeveAlugarFilmeComErrorCollector() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		List<Filme> listFilmes = Arrays.asList(new Filme("Batman Begins", 2, 6.50));

		Locacao locacao = locacaoService.alugarFilme(usuario, listFilmes);

		errors.checkThat(locacao.getValor(), is(equalTo(6.50)));
		errors.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		errors.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
	}

	/**
	 * Teste passando uma exception na anotaï¿½ï¿½o, onde o teste vai ser validado
	 * se realmente for lanï¿½ado a exceï¿½ï¿½o esperada e somente deve ser usado
	 * quando realmente tiver certeza do retorno da exceï¿½ï¿½o esperada, uma forma
	 * mais elegante
	 * 
	 * JUnit faz todo tratamento de exceï¿½ï¿½o.
	 * 
	 * @throws Exception
	 */
	@Test(expected = FilmeSemEstoqueException.class)
	public void testeNaoDeveAlugarFilmeSemEstoque() throws Exception {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		List<Filme> listFilmes = Arrays.asList(new Filme("Batman Begins", 0, 6.50));

		locacaoService.alugarFilme(usuario, listFilmes);
	}

	/**
	 * Mesma finalidade do mï¿½todo testeLocacaoFilmeSemEstoque, porï¿½m aqui
	 * tratamos a exceï¿½ï¿½o de forma mais clara no prï¿½prio cï¿½digo, uma forma
	 * mais robusta.
	 * 
	 * Instrutor recomenda usar essa forma, pelo fato de ser mais completa, ou seja,
	 * robusta.
	 * 
	 * @throws LocadoraException
	 * 
	 * @throws Exception
	 */
//	@Test
//	public void testeNaoDeveAlugarFilmeSemEstoque2() throws Exception {
//		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
//		List<Filme> listFilmes = Arrays.asList(new Filme("Batman Begins", 0, 6.50));
//
//		try {
//			locacaoService.alugarFilme(usuario, listFilmes);
//			Assert.fail("Deveria ter lanï¿½ado uma exceï¿½ï¿½o");
//		} 
//		catch (Exception e) {
//			assertThat(e.getMessage(), is("Filme sem estoque"));
//		}
//	}

	/**
	 * Teste utilizando ExpectedException, onde dizemos qual exceï¿½ï¿½o ï¿½
	 * esperada a ser lanï¿½ada e qual o tipo de mensagem de retorno
	 * 
	 * JUnit faz todo tratamento de exceï¿½ï¿½o.
	 * 
	 * @throws FilmeSemEstoqueException
	 * 
	 * @throws Exception
	 */
//	@Test
//	public void testeNaoDeveAlugarFilmeSemEstoque3() throws Exception {
//		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
//		List<Filme> listFilmes = Arrays.asList(new Filme("Batman Begins", 0, 6.50));
//
//		expectedException.expect(Exception.class);
//		expectedException.expectMessage("Filme sem estoque");
//
//		locacaoService.alugarFilme(usuario, listFilmes);
//	}

	/**
	 * Essa ï¿½ a forma mais pratica de se usar a forma elegante, porï¿½m, quando se
	 * passa a prï¿½pria exception customizada no programa, e nï¿½o uma simples
	 * exception genï¿½rica
	 * 
	 * Teste passando uma exception na anotaï¿½ï¿½o, onde o teste vai ser validado
	 * se realmente for lanï¿½ado a exceï¿½ï¿½o esperada.
	 * 
	 * JUnit faz todo tratamento de exceï¿½ï¿½o.
	 * 
	 * @throws Exception
	 */
	@Test(expected = FilmeSemEstoqueException.class)
	public void testeNaoDeveAlugarFilmeSemEstoque4() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		List<Filme> listFilmes = Arrays.asList(new Filme("Batman Begins", 0, 6.50));

		locacaoService.alugarFilme(usuario, listFilmes);
	}

	/**
	 * Teste que faz a validaï¿½ï¿½o de usuï¿½rio com base na forma robusta
	 * 
	 * * Instrutor recomenda usar essa forma, pelo fato de ser mais completa, ou
	 * seja, robusta.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testeNaoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		List<Filme> listFilmes = new ArrayList<Filme>();

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));

		try {
			locacaoService.alugarFilme(null, listFilmes);
			Assert.fail();
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuï¿½rio obrigatï¿½rio"));
		}
	}

	/**
	 * Teste que faz a validaï¿½ï¿½o de filme com base na forma nova
	 * 
	 * @throws Exception
	 */
	@Test()
	public void testeNaoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Josimar Ribeiro Cardoso");
		List<Filme> listFilmes = new ArrayList<Filme>();

		listFilmes.add(null);
		listFilmes.add(null);

		expectedException.expect(LocadoraException.class);
		expectedException.expectMessage("Filme obrigatï¿½rio");

		locacaoService.alugarFilme(usuario, listFilmes);
	}

	/**
	 * Teste que valida se o valor total a pagar estÃ¡ sendo calculado com o
	 * desconto de 25%.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testePagarCom25PorcentoDeDesconto3Filme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Isabelle Fernandes de Campos");
		List<Filme> listFilmes = new ArrayList<Filme>();
		Locacao locacao;

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));
		listFilmes.add(new Filme("Busca ImplacÃ¡vel1", 10, 6.50));

		locacao = locacaoService.alugarFilme(usuario, listFilmes);

		Assert.assertEquals(17.88, locacao.getValor(), 0.01);
	}

	/**
	 * Teste que valida se o valor total a pagar estÃ¡ sendo calculado com o
	 * desconto de 50%.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testePagarCom50PorcentoDeDesconto4Filme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Isabelle Fernandes de Campos");
		List<Filme> listFilmes = new ArrayList<Filme>();
		Locacao locacao;

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));
		listFilmes.add(new Filme("Busca ImplacÃ¡vel1", 10, 6.50));
		listFilmes.add(new Filme("Busca ImplacÃ¡vel2", 10, 6.50));

		locacao = locacaoService.alugarFilme(usuario, listFilmes);

		Assert.assertEquals(21.12, locacao.getValor(), 0.01);
	}

	/**
	 * Teste que valida se o valor total a pagar estÃ¡ sendo calculado com o
	 * desconto de 75%.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testePagarCom75PorcentoDeDesconto5Filme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Luiz Souza");
		List<Filme> listFilmes = new ArrayList<Filme>();
		Locacao locacao;

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));
		listFilmes.add(new Filme("Busca ImplacÃ¡vel 1", 10, 6.50));
		listFilmes.add(new Filme("A Era do Gelo 1", 10, 6.50));
		listFilmes.add(new Filme("Need for Speed", 10, 6.50));

		locacao = locacaoService.alugarFilme(usuario, listFilmes);

		Assert.assertEquals(22.75, locacao.getValor(), 0.01);

	}

	/**
	 * Teste que valida se o valor total a pagar estÃ¡ sendo calculado com o
	 * desconto de 100%.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testePagarCom100PorcentoDeDesconto6Filme() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Luiz Souza");
		List<Filme> listFilmes = new ArrayList<Filme>();
		Locacao locacao;

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));
		listFilmes.add(new Filme("Avatar 2", 10, 6.50));
		listFilmes.add(new Filme("Busca ImplacÃ¡vel 1", 10, 6.50));
		listFilmes.add(new Filme("A Era do Gelo 1", 10, 6.50));
		listFilmes.add(new Filme("Need for Speed", 10, 6.50));
		listFilmes.add(new Filme("Quarto de Guerra", 10, 6.50));

		locacao = locacaoService.alugarFilme(usuario, listFilmes);

		Assert.assertEquals(22.75, locacao.getValor(), 0.01);
	}

	/**
	 * Teste que valida se o filme vai ser devolvido no domingo.
	 * 
	 * @throws void
	 */
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
		// Uma forma de garantir que considere o teste apenas quando o dia for sÃ¡bado
		Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));

		Usuario usuario = new Usuario("Luiz Souza");
		List<Filme> listFilmes = new ArrayList<Filme>();

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));

		Locacao locacao = locacaoService.alugarFilme(usuario, listFilmes);

		boolean eSegunda = DataUtils.verificarDiaSemana(locacao.getDataRetorno(), Calendar.MONDAY);

		Assert.assertTrue(eSegunda);

		// Validação com Matcher
		assertThat(locacao.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));

		// Validação com matcher próprio
		assertThat(locacao.getDataRetorno(), caiEm(Calendar.MONDAY));
		assertThat(locacao.getDataRetorno(), caiNumaSegunda());

	}

}
