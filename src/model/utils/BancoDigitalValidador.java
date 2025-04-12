package model.utils;

import java.util.List;

import model.entities.ContaBancaria;
import model.exceptions.ContaNaoEncontradaException;
import model.exceptions.ContaNulaException;

public class BancoDigitalValidador {

	public static void validarContaNula(ContaBancaria conta) {
		if (conta == null) {
			throw new ContaNulaException("A conta não pode ser nula.");
		}
	}

	public static void validarContaExistente(Integer numeroConta, List<ContaBancaria> contas) {
		boolean contaExiste = contas.stream().anyMatch(conta -> conta.getNumeroConta().equals(numeroConta));
		if (!contaExiste) {
			throw new ContaNaoEncontradaException("Conta não encontrada.");
		}
	}

}
