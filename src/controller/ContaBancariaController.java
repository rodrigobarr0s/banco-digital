package controller;

import model.entities.ContaBancaria;
import model.services.OperacoesBancariasServices;
import model.utils.Log;
import model.exceptions.SaldoInsuficienteException;
import model.exceptions.ValorNegativoException;
import model.exceptions.ValorNuloException;

public class ContaBancariaController {

    private OperacoesBancariasServices operacoesService;

    public ContaBancariaController() {
        operacoesService = new OperacoesBancariasServices();
    }

    public void realizarDeposito(ContaBancaria conta, Double valor) {
        try {
            operacoesService.depositar(conta, valor);
            Log.info("Depósito de R$ " + valor + " realizado com sucesso na conta " + conta.getNumeroConta());
        } catch (ValorNuloException | ValorNegativoException e) {
            Log.error("Erro ao realizar depósito na conta " + conta.getNumeroConta() + ": " + e.getMessage(), e);
        } catch (RuntimeException e) {
            Log.error("Erro inesperado ao realizar depósito na conta " + conta.getNumeroConta() + ": " + e.getMessage(), e);
        }
    }

    public void realizarSaque(ContaBancaria conta, Double valor) {
        try {
            operacoesService.sacar(conta, valor);
            Log.info("Saque de R$ " + valor + " realizado com sucesso na conta " + conta.getNumeroConta());
        } catch (SaldoInsuficienteException e) {
            Log.error("Erro ao realizar saque na conta " + conta.getNumeroConta() + ": " + e.getMessage(), e);
        } catch (ValorNuloException | ValorNegativoException e) {
            Log.error("Erro ao realizar saque na conta " + conta.getNumeroConta() + ": " + e.getMessage(), e);
        } catch (RuntimeException e) {
            Log.error("Erro inesperado ao realizar saque na conta " + conta.getNumeroConta() + ": " + e.getMessage(), e);
        }
    }

    public void realizarTransferencia(ContaBancaria origem, ContaBancaria destino, Double valor) {
        try {
            operacoesService.transferir(origem, destino, valor);
            Log.info("Transferência de R$ " + valor + " da conta " + origem.getNumeroConta() + " para a conta " + destino.getNumeroConta() + " realizada com sucesso.");
        } catch (SaldoInsuficienteException e) {
            Log.error("Erro ao realizar transferência de R$ " + valor + " da conta " + origem.getNumeroConta() + " para a conta " + destino.getNumeroConta() + ": " + e.getMessage(), e);
        } catch (ValorNuloException | ValorNegativoException e) {
            Log.error("Erro ao realizar transferência de R$ " + valor + " da conta " + origem.getNumeroConta() + " para a conta " + destino.getNumeroConta() + ": " + e.getMessage(), e);
        } catch (RuntimeException e) {
            Log.error("Erro inesperado ao realizar transferência de R$ " + valor + " da conta " + origem.getNumeroConta() + " para a conta " + destino.getNumeroConta() + ": " + e.getMessage(), e);
        }
    }
}
