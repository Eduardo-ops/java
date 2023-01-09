package br.com.domain.services;

import static br.com.domain.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.exceptions.FilmeSemEstoqueException;
import br.com.domain.exceptions.LocadoraException;

public class LocacaoService {

	public Locacao alugarFilme(Usuario usuario, List<Filme> listFilmes) throws FilmeSemEstoqueException, LocadoraException {

		if (usuario == null) {
			throw new LocadoraException("Usuário obrigatório");
		}

		for (Filme filme : listFilmes) {
			if (filme == null) {
				throw new LocadoraException("Filme obrigatório");
			}

			if (filme.getEstoque() == 0) {
				// throw new FilmeSemEstoqueException();
				throw new FilmeSemEstoqueException();
			}
		}

		Locacao locacao = new Locacao();
		locacao.setFilme(listFilmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		double valorTotal = 0;

		for (Filme filme : listFilmes) {
			valorTotal += filme.getPrecoLocacao();
		}

		locacao.setValor(valorTotal);

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar mÃ©todo para salvar

		return locacao;
	}
}