package br.com.domain.dao;

import java.util.List;

import br.com.domain.entities.Locacao;

public class LocacaoDAOFake implements LocacaoDAO {

	@Override
	public void salvar(Locacao Locacao) {
		
	}

	@Override
	public List<Locacao> obterLocacoesPendentes() {
		return null;
	}

}
