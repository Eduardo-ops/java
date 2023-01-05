package br.com.domain.services;

import java.util.Date;

import br.com.domain.entities.Filme;
import br.com.domain.entities.Locacao;
import br.com.domain.entities.Usuario;
import br.com.domain.utils.DataUtils;

public class LocacaoServiceTest {

	/**
	 * Teste sem a utilizaçao de ferramenta
	 */
	public static void main(String[] args) throws Exception {
		LocacaoService locacaoService = new LocacaoService();
		boolean result = false;

		// Cenario
		Usuario usuario = new Usuario("Eduardo Isidoro Gonçalves");
		Filme filme = new Filme("Avatar 2", 10, 6.50);

		// Acao
		Locacao locacao = locacaoService.alugarFilme(usuario, filme);

		// Validacao
		System.out.println(locacao.getValor() == 6.50);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
}
