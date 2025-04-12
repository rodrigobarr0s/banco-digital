package model.entities;

import model.services.NomeAleatorioService;

public class Cliente {

	private final String name;

	public Cliente(NomeAleatorioService nomeAleatorioService) {
		this.name = nomeAleatorioService.gerarNome();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Cliente [name=" + name + "]";
	}

}
