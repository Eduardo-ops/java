package br.com.domain.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.exceptions.FilmeSemEstoqueException;
import br.com.domain.exceptions.LocadoraException;

/**
 * Classe responsável por realizar a bateria de testes de forma automatizada,
 * sobre a RN de porcentagem de descontos nos filmes alugados.
 */
@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {

	private LocacaoService locacaoService;

	@Parameter
	public List<Filme> listFilmes;

	@Parameter(value = 1)
	public Double valorLocacao;

	@Parameter(value = 2)
	public String cenario;

	@Before
	public void setup() {
		locacaoService = new LocacaoService();
	}

	private static Filme filme1 = new Filme("filme1", 5, 4.0);
	private static Filme filme2 = new Filme("filme2", 5, 4.0);
	private static Filme filme3 = new Filme("filme3", 5, 4.0);
	private static Filme filme4 = new Filme("filme4", 5, 4.0);
	private static Filme filme5 = new Filme("filme5", 5, 4.0);
	private static Filme filme6 = new Filme("filme6", 5, 4.0);

	@Parameters(name = "{2}")
	public static Collection<Object[]> getParametros() {
		return Arrays.asList(new Object[][] { { Arrays.asList(filme1, filme2, filme3), 11.00, "3 Filmes 25%" },
				{ Arrays.asList(filme1, filme2, filme3, filme4), 12.25, "4 Filmes 50%" },
				{ Arrays.asList(filme1, filme2, filme3, filme4, filme5), 11.6875, "5 Filmes 75%" },
				{ Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 10.015625, "6 Filmes 100%" }, });
	}

	/**
	 * Teste que valida se o valor total a pagar está sendo calculado com o desconto
	 * de acordo com os parametros
	 * 
	 * @throws Exception
	 */
	@Test
	public void testePagarFimesComDescontos() throws FilmeSemEstoqueException, LocadoraException {
		Usuario usuario = new Usuario("Isabelle Fernandes de Campos");

		Locacao locacao = locacaoService.alugarFilme(usuario, listFilmes);

		assertThat(locacao.getValor(), is(valorLocacao));

		System.out.println("!");
	}

}
