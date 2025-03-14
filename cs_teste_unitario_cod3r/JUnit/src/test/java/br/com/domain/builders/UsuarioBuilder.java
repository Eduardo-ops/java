package br.com.domain.builders;

import br.com.domain.entities.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;

	private UsuarioBuilder() {

	}

	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario();
		builder.usuario.setNome("Usuario 1");

		return builder;
	}
	
	public UsuarioBuilder ComNome(String nome) {
		usuario.setNome(nome);
		
		return this;
	}

	public Usuario novoUsuario() {
		return usuario;
	}

}
