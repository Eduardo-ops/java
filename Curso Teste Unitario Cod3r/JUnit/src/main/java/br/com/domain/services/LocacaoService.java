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

	public Locacao alugarFilme(Usuario usuario, List<Filme> listFilmes)
			throws FilmeSemEstoqueException, LocadoraException {

		// RN Usuário obrigatório
		if (usuario == null) {
			throw new LocadoraException("Usu�rio obrigat�rio");
		}

		// RN Filme obrigatório
		for (Filme filme : listFilmes) {
			if (filme == null) {
				throw new LocadoraException("Filme obrigat�rio");
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

		// RN desconto no último filme de acordo com a quantidade
		if (listFilmes.size() == 3) {
			listFilmes.get(2).setPrecoLocacao(
					listFilmes.get(2).getPrecoLocacao() - (listFilmes.get(2).getPrecoLocacao() * 0.25));

			for (Filme filme : listFilmes) {
				valorTotal += filme.getPrecoLocacao();
			}
		} 
		else if (listFilmes.size() == 4) {
			listFilmes.get(3).setPrecoLocacao(
					listFilmes.get(3).getPrecoLocacao() - (listFilmes.get(3).getPrecoLocacao() * 0.50));

			for (Filme filme : listFilmes) {
				valorTotal += filme.getPrecoLocacao();
			}
		} 
		else if (listFilmes.size() == 5) {
			listFilmes.get(4).setPrecoLocacao(
					listFilmes.get(4).getPrecoLocacao() - (listFilmes.get(4).getPrecoLocacao() * 0.75));
			System.out.println(listFilmes.get(4).getPrecoLocacao());

			for (Filme filme : listFilmes) {
				valorTotal += filme.getPrecoLocacao();
			}
		} 
		else if (listFilmes.size() == 6) {
			listFilmes.get(5)
					.setPrecoLocacao(listFilmes.get(5).getPrecoLocacao() - (listFilmes.get(5).getPrecoLocacao() * 1));

			for (Filme filme : listFilmes) {
				valorTotal += filme.getPrecoLocacao();
			}
		}

		locacao.setValor(valorTotal);

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// TODO adicionar método para salvar

		return locacao;
	}
}