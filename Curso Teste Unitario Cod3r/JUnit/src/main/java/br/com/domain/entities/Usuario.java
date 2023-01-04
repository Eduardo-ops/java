package br.com.domain.entities;

public class Usuario {

	private String nome;

	public Usuario() {
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}