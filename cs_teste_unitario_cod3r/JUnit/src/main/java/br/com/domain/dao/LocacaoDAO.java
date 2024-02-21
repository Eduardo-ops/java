package br.com.domain.dao;

import java.util.List;

import br.com.domain.entities.Locacao;

public interface LocacaoDAO {

	public void salvar(Locacao Locacao);
	
	public List<Locacao> obterLocacoesPendentes();
}
