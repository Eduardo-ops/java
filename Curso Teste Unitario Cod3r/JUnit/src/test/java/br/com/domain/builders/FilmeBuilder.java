package br.com.domain.builders;

import br.com.domain.entities.Filme;

public class FilmeBuilder {

	private Filme filme;

	private FilmeBuilder() {

	}

	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("A lagora azul");
		builder.filme.setPrecoLocacao(6.50);
		builder.filme.setEstoque(10);

		return builder;
	}

	public FilmeBuilder novoFilmeSemEstoque1() {
		filme.setEstoque(0);

		return this;
	}

	public FilmeBuilder novoFilmeSemEstoque2() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("A lagora azul");
		builder.filme.setPrecoLocacao(6.50);
		builder.filme.setEstoque(0);

		return builder;
	}
	
	public FilmeBuilder comValor(Double valor) {
		filme.setPrecoLocacao(valor);
		
		return this;
	}

	public Filme novoFilme() {
		return filme;
	}
}
