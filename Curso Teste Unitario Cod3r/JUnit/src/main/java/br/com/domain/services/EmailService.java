package br.com.domain.services;

import br.com.domain.entities.Usuario;

public interface EmailService {
	
	public void notificarAtraso(Usuario usuario);
}
