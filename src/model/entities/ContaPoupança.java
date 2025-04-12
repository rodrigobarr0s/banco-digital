package model.entities;

import model.utils.TransacaoValidador;

public class ContaPoupança extends ContaBancaria {

	private static final double TAXA_RENDIMENTO = 0.005; // 0,5% ao mês

	public ContaPoupança() {
		super();
	}

	@Override
	public String getTipoConta() {
		return "Conta Poupança";
	}

	public void aplicarRendimento() {
		Double rendimento = getSaldo() * TAXA_RENDIMENTO;
		setSaldo(getSaldo() + rendimento);
	}

	@Override
	public void sacar(Double valor) {
		TransacaoValidador.validarTransacao(this, valor);
		setSaldo(getSaldo() - valor);
	}

}
