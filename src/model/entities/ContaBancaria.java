package model.entities;

import model.services.NomeAleatorioService;

public abstract class ContaBancaria {

	private static final String AGENCIA_PADRAO = "0001";
	private static Integer contador = 1;

	private String agencia;
	private Integer numeroConta;
	private Cliente cliente;
	private Double saldo;

	public ContaBancaria() {
		agencia = AGENCIA_PADRAO;
		numeroConta = contador++;
		cliente = new Cliente(new NomeAleatorioService());
		saldo = 0.0;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public abstract String getTipoConta();
	
	public abstract void sacar(Double valor);

	@Override
	public String toString() {
		return "Conta [agencia=" + agencia + ", numeroConta=" + numeroConta + ", cliente=" + cliente + ", saldo="
				+ saldo + "]";
	}

}
