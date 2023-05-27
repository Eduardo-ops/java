package br.com.domain.services;

import static br.com.domain.matchers.MatchersProprios.caiNumaSegunda;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.com.domain.builders.FilmeBuilder;
import br.com.domain.builders.UsuarioBuilder;
import br.com.domain.dao.LocacaoDAO;
import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.exceptions.FilmeSemEstoqueException;
import br.com.domain.exceptions.LocadoraException;
import br.com.domain.utils.DataUtils;

@RunWith(PowerMockRunner.class)
@PrepareForTest(LocacaoService.class)
public class LocacaoServicePowerMockTest {

	private LocacaoService locacaoService;

	private LocacaoDAO locacaoDAO;

	@Rule
	public ErrorCollector errors = new ErrorCollector();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void setup() {
		System.out.println("Before");
		this.locacaoService = PowerMockito.spy(this.locacaoService);
		locacaoDAO = Mockito.mock(LocacaoDAO.class);
		this.locacaoService.setLocacaoDAO(locacaoDAO);
	}

	/**
	 * Teste que valida se o filme vai ser devolvido no domingo, com o adicional de
	 * estar mockando também, o construtor do Date @throws void
	 */
	@Test
	public void testeAlugarFilmeMockandoOConstrunstutorDoDate() throws Exception {
		Usuario usuario = new Usuario("Luiz Souza");
		List<Filme> listFilmes = new ArrayList<Filme>();
		SPCService mockSpcService = Mockito.mock(SPCService.class);
		this.locacaoService.setSpcService(mockSpcService);

		/*
		 * Mockando o construtor do Date, permitindo que o new Date, retorne uma data de
		 * nossa preferencia
		 */
		PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(DataUtils.obterData(29, 4, 2017));

		listFilmes.add(new Filme("Batman Begins", 5, 6.50));

		Locacao locacao = locacaoService.alugarFilme(usuario, listFilmes);

		assertThat(locacao.getDataRetorno(), caiNumaSegunda());

		// Verificando se o construtor foi chamado
		PowerMockito.verifyNew(Date.class, Mockito.times(2)).withNoArguments();
	}

	/**
	 * Método que realiza o teste de mockar os método estáticos
	 * Observação: Para este teste em específico, não tem necessidade da anotação no
	 * início da classe, @PrepareForTest com Date.class
	 * @throws FilmeSemEstoqueException - Exception que pode retornar do método
	 * @throws LocadoraException        - Exception que pode retornar do método
	 */
	@Test
	public void testeGerarDateComCalendar() throws FilmeSemEstoqueException, LocadoraException {
		Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.DAY_OF_MONTH, 29);
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.YEAR, 2017);

		PowerMockito.mockStatic(Calendar.class);
		PowerMockito.when(Calendar.getInstance()).thenReturn(calendar);

		this.locacaoService.gerarDateComCalendar();

		PowerMockito.verifyStatic();
		Calendar.getInstance();
	}

	/**
	 * Teste do método alugarFilme, demonstrando o processo de mockar um método
	 * private
	 * @throws Exception- Exception que pode retornar do método
	 */
	@Test
	public void testeDeveAlugarFilmeSemCalcularValor() throws Exception {
		Usuario usuario = UsuarioBuilder.umUsuario().novoUsuario();
		List<Filme> listaFilmes = Arrays.asList(FilmeBuilder.umFilme().novoFilme());

		PowerMockito.doReturn(1.0).when(this.locacaoService, "calcularValorLocacao", listaFilmes);

		Locacao locacao = this.locacaoService.alugarFilme(usuario, listaFilmes);

		Assert.assertEquals(locacao.getValor(), 1.0, 0.01);
		PowerMockito.verifyPrivate(this.locacaoService).invoke("calcularValorLocacao", listaFilmes);
	}

	/**
	 * Teste do método alugarFilme, demonstrando o processo de mockar um método
	 * private e de forma que o execute de forma diretamente
	 * @Obs Não é uma forma recomendada, uma forma melhor e mais robusta, seria testar o método private pelo método público que a chama
	 * @throws Exception- Exception que pode retornar do método
	 */
	@Test
	public void testeDeveCalcularValorLocacao() throws Exception {
		Usuario usuario = UsuarioBuilder.umUsuario().novoUsuario();
		List<Filme> listaFilmes = Arrays.asList(FilmeBuilder.umFilme().novoFilme());

		Double valor = (Double) Whitebox.invokeMethod(this.locacaoService, "calcularValorLocacao", listaFilmes);

		Assert.assertEquals(valor, 4.0, 0.01);
	}
	
	/**
	 * Este método é um exemplo de testar método private de forma direta,sem a utilizacao de powerMock e sim,
	 * utilizando a própria api do java, reflection
	 * @throws Exception - Este é uma exception que pode ser lançada
	 */
	@Test
	public void testeDeveCalcularValorLocacaoUtilizandoReflectionParaTestarMetodoPrivate() throws Exception {
		Usuario usuario = UsuarioBuilder.umUsuario().novoUsuario();
		List<Filme> listaFilmes = Arrays.asList(FilmeBuilder.umFilme().novoFilme());

		Class<LocacaoService> reflectionLocacaoService = LocacaoService.class;

		// Este modo só permite ter acesso a métodos visíveis da classe
		// Method metodo = reflectionLocacaoService.getMethod(null, null);

		// Este modo permite ter acesso a todos os métodos da classe
		Method metodoPrivateCalcularValorLocacao = reflectionLocacaoService.getDeclaredMethod("calcularValorLocacao",
				List.class);

		// O método invoke é genérico, então, utilizamos o cast para conversão
		Double valor = (Double) metodoPrivateCalcularValorLocacao.invoke(locacaoService, listaFilmes);

		Assert.assertEquals(valor, 4.0, 0.01);
	}
}
