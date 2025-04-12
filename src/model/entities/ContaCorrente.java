package model.entities;

import model.exceptions.SaldoInsuficienteException;
import model.utils.TransacaoValidador;

public class ContaCorrente extends ContaBancaria {

	private static final double LIMITE_CHEQUE_ESPECIAL = 500.0; // limite de cheque especial

	public ContaCorrente() {
		super();
	}

	@Override
	public String getTipoConta() {
		return "Conta Corrente";
	}

	@Override
	public void sacar(Double valor) {
		// Valida se o valor solicitado é válido
		TransacaoValidador.validarValor(valor);

		// Verifica se o saldo + limite de cheque especial é suficiente
		if (valor > (getSaldo() + LIMITE_CHEQUE_ESPECIAL)) {
			throw new SaldoInsuficienteException("Saldo insuficiente, incluindo o limite de cheque especial.");
		}

		// Atualiza o saldo da conta
		setSaldo(getSaldo() - valor);
	}

}
