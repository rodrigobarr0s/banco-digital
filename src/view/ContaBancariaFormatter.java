package view;

import model.entities.ContaBancaria;

public class ContaBancariaFormatter {

	public static String formatterConta(ContaBancaria conta) {

		return String.format(
				"=== %s ====\n" + "Agencia: %s\n" + "Numero da conta: %d\n" + "Titular: %s\n"
						+ "Saldo: R$ %.2f\n" + "=======================",
				conta.getTipoConta(), conta.getAgencia(), conta.getNumeroConta(), conta.getCliente().getName(),
				conta.getSaldo());
	}

	public static String formatterExtrato(ContaBancaria conta) {

		return String.format(
				"=== Extrato %s ===\n" + "Agencia: %s\n" + "Numero da conta: %d\n" + "Titular: %s\n"
						+ "Saldo: R$ %.2f\n" + "==============================",
				conta.getTipoConta(), conta.getAgencia(), conta.getNumeroConta(), conta.getCliente().getName(),
				conta.getSaldo());
	}
}
