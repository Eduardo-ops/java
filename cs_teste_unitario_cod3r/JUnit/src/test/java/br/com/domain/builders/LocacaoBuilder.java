package br.com.domain.builders;

import java.util.Arrays;
import java.util.Date;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.utils.DataUtils;

public class LocacaoBuilder {

	private Locacao locacao;

	private LocacaoBuilder() {

	}

	public static LocacaoBuilder umaLocacao() {
		LocacaoBuilder locacaoBuilder = new LocacaoBuilder();
		inicializarDadosPadroes(locacaoBuilder);
		return locacaoBuilder;
	}

	public static void inicializarDadosPadroes(LocacaoBuilder locacaoBuilder) {
		locacaoBuilder.locacao = new Locacao();
		Locacao elemento = locacaoBuilder.locacao;

		elemento.setUsuario(UsuarioBuilder.umUsuario().novoUsuario());
		elemento.setFilme(Arrays.asList(FilmeBuilder.umFilme().novoFilme()));
		elemento.setDataLocacao(new Date());
		elemento.setDataRetorno(DataUtils.obterDataComDiferencaDias(1));
		elemento.setValor(6.50);
	}

	public LocacaoBuilder comUsuario(Usuario param) {
		locacao.setUsuario(param);
		return this;
	}

	public LocacaoBuilder comListaListFilmes(Filme... params) {
		locacao.setFilme(Arrays.asList(params));
		return this;
	}

	public LocacaoBuilder comDataLocacao(Date param) {
		locacao.setDataLocacao(param);
		return this;
	}

	public LocacaoBuilder comDataRetorno(Date param) {
		locacao.setDataRetorno(param);
		return this;
	}

	public LocacaoBuilder comValor(Double param) {
		locacao.setValor(param);
		return this;
	}

	public Locacao novaLocacao() {
		return locacao;
	}
}
