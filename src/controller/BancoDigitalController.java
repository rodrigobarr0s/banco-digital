package controller;

import java.util.List;

import model.entities.ContaBancaria;
import model.exceptions.ContaNaoEncontradaException;
import model.exceptions.ContaNulaException;
import model.services.BancoDigitalService;
import model.utils.BancoDigitalValidador;
import model.utils.Log;
import view.ContaBancariaFormatter;

public class BancoDigitalController {

    private BancoDigitalService bancoDigitalService;

    public BancoDigitalController() {
        bancoDigitalService = new BancoDigitalService();
    }

    public void adicionarConta(ContaBancaria conta) {
        try {
            BancoDigitalValidador.validarContaNula(conta); // Validação de conta nula
            bancoDigitalService.adicionarConta(conta);
            Log.info("Conta adicionada com sucesso! Número da conta: " + conta.getNumeroConta());
        } catch (ContaNulaException e) {
            Log.error("Erro ao adicionar conta: " + e.getMessage(), e);  // Usando Log.error para capturar exceções específicas
        } catch (RuntimeException e) {
            Log.error("Erro inesperado ao adicionar conta: " + e.getMessage(), e);  // Detalhando erro inesperado
        }
    }

    public void listarContas() {
        try {
            List<ContaBancaria> contas = bancoDigitalService.listarContas();
            if (contas.isEmpty()) {
                System.out.println("Não há contas cadastradas.");
            } else {
                for (ContaBancaria conta : contas) {
                    System.out.println(ContaBancariaFormatter.formatterConta(conta));
                }
            }
        } catch (RuntimeException e) {
            Log.error("Erro ao listar contas: " + e.getMessage(), e);  // Usando Log.error para capturar erros inesperados
        }
    }

    public void buscarContaPorNumero(Integer numeroConta) {
        try {
            BancoDigitalValidador.validarContaExistente(numeroConta, bancoDigitalService.listarContas()); // Validação de conta existente
            ContaBancaria conta = bancoDigitalService.buscarContaPorNumero(numeroConta);
            System.out.println(ContaBancariaFormatter.formatterConta(conta));
        } catch (ContaNaoEncontradaException e) {
            Log.error("Erro ao buscar conta com número " + numeroConta + ": " + e.getMessage(), e);  // Log de erro específico
        } catch (RuntimeException e) {
            Log.error("Erro inesperado ao buscar conta com número " + numeroConta + ": " + e.getMessage(), e);  // Log de erro inesperado
        }
    }
}
