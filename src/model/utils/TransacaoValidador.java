package model.utils;

import model.entities.ContaBancaria;
import model.exceptions.SaldoInsuficienteException;
import model.exceptions.ValorNegativoException;
import model.exceptions.ValorNuloException;

public class TransacaoValidador {

	public static void validarValor(Double valor) {
		if (valor == null) {
			throw new ValorNuloException("O valor informado não pode ser nulo.");
		} else if (valor <= 0) {
			throw new ValorNegativoException("O valor deve ser maior que zero.");
		}
	}

	public static void validarSaldo(ContaBancaria conta, Double valor) {
		if (valor > conta.getSaldo()) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar esta operação.");
		}
	}

	public static void validarTransacao(ContaBancaria conta, Double valor) {
		validarValor(valor);
		validarSaldo(conta, valor);
	}
}
