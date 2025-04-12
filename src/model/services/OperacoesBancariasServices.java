package model.services;

import model.entities.ContaBancaria;
import model.utils.TransacaoValidador;

public class OperacoesBancariasServices {

	public void depositar(ContaBancaria conta, Double valor) {
		TransacaoValidador.validarValor(valor);
		conta.setSaldo(conta.getSaldo() + valor);
	}

	public void sacar(ContaBancaria conta, Double valor) {
		conta.sacar(valor);
	}

	public void transferir(ContaBancaria origem, ContaBancaria destino, Double valor) {
		TransacaoValidador.validarTransacao(origem, valor);
		sacar(origem, valor);
		depositar(destino, valor);
	}
}
