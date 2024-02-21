package br.com.domain.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.utils.DataUtils;

public class LocacaoServiceTestSemFerramenta {

	/**
	 * Teste sem a utilizaçao de ferramenta
	 */
	public static void main(String[] args) throws Exception {
		LocacaoService locacaoService = new LocacaoService();
		boolean result = false;

		// Cenario
		Usuario usuario = new Usuario("Eduardo Isidoro Gonçalves");
		List<Filme> listFilmes = new ArrayList<Filme>();
		listFilmes.add(new Filme("Batman Begins", 10, 6.50));

		// Acao
		Locacao locacao = locacaoService.alugarFilme(usuario, listFilmes);

		// Validacao
		System.out.println(locacao.getValor() == 6.50);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}
