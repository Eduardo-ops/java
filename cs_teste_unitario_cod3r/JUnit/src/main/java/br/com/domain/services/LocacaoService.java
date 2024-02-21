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
	private SPCService spcService;
	private EmailService emailService;

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

		boolean usuarioNegativado;

		// RN SPC
		try {
			usuarioNegativado = spcService.posssuiNegativacao(usuario);
		} catch (Exception e) {
			throw new LocadoraException(
					"Não foi possível dar continuidade no aluguel, verifique se há alguma pendência nos dados pessoais.");
		}

		if (usuarioNegativado) {
			throw new LocadoraException("Usuário Negativado.");
		}

		Locacao locacao = new Locacao();
		locacao.setFilme(listFilmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		
		// RN desconto no último filme de acordo com a quantidade
		double valorTotal = calcularValorLocacao(listFilmes);

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

	private double calcularValorLocacao(List<Filme> listFilmes) {
		System.out.println("Método calcularValorLocacao");
		double valorTotal = 0;

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
		
		return valorTotal;
	}

	/**
	 * RN que faz a notificação de atrasos.
	 */
	public void notificarAtrasos() {
		List<Locacao> listLocacao = locacaoDAO.obterLocacoesPendentes();

		for (Locacao locacao : listLocacao) {
			if (locacao.getDataRetorno().before(new Date())) {
				emailService.notificarAtraso(locacao.getUsuario());
			}
		}
	}

	/**
	 * Método que permite prorrogar locacao.
	 * 
	 * @param locacao
	 * @param dias
	 */
	public void prorrogarLocacao(Locacao locacao, int dias) {
		Locacao novaLocacao = new Locacao();

		novaLocacao.setUsuario(locacao.getUsuario());
		novaLocacao.setFilme(locacao.getFilme());
		novaLocacao.setDataLocacao(locacao.getDataLocacao());
		novaLocacao.setDataRetorno(DataUtils.obterDataComDiferencaDias(dias));
		novaLocacao.setValor(locacao.getValor() * dias);

		locacaoDAO.salvar(novaLocacao);
	}

	/**
	 * Método que gera uma data do tipo Calendar, para exemplo de Mock com metodos
	 * estaticos
	 * 
	 * @return Este método retorna um data do tipo Calendar
	 */
	public Calendar gerarDateComCalendar() {
		Calendar data = Calendar.getInstance();

		return data;
	}

	public void setLocacaoDAO(LocacaoDAO locacaoDAO) {
		this.locacaoDAO = locacaoDAO;
	}

	public void setSpcService(SPCService spcService) {
		this.spcService = spcService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
}