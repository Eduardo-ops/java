package br.com.domain.services;

import static br.com.domain.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.domain.dao.LocacaoDAO;
import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.exceptions.FilmeSemEstoqueException;
import br.com.domain.exceptions.LocadoraException;
import br.com.domain.utils.DataUtils;

public class LocacaoService {

	private LocacaoDAO locacaoDAO;

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
		for (int i = 0; i < listFilmes.size(); i++) {
			switch (i) {
			case 2:
				listFilmes.get(i).setPrecoLocacao(listFilmes.get(i).getPrecoLocacao() * 0.75);
				break;
			case 3:
				listFilmes.get(i).setPrecoLocacao(listFilmes.get(i).getPrecoLocacao() * 0.50);
				break;
			case 4:
				listFilmes.get(i).setPrecoLocacao(listFilmes.get(i).getPrecoLocacao() * 0.25);
				break;
			case 5:
				listFilmes.get(i).setPrecoLocacao(0.0);
			}

			valorTotal = valorTotal + listFilmes.get(i).getPrecoLocacao();
		}

		locacao.setValor(valorTotal);

		// Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);

		if (DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
			dataEntrega = adicionarDias(dataEntrega, 1);
		}

		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao
		locacaoDAO.salvar(locacao);

		return locacao;
	}

	public void setLocacaoDAO(LocacaoDAO locacaoDAO) {
		this.locacaoDAO = locacaoDAO;
	}
}