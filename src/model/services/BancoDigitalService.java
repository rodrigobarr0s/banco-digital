package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.ContaBancaria;
import model.exceptions.ContaNaoEncontradaException;
import model.utils.BancoDigitalValidador;

public class BancoDigitalService {

    private List<ContaBancaria> contas;

    public BancoDigitalService() {
        contas = new ArrayList<>();
    }

    public void adicionarConta(ContaBancaria conta) {
        BancoDigitalValidador.validarContaNula(conta); // Validação antes de adicionar
        contas.add(conta);
    }

    public List<ContaBancaria> listarContas() {
        return contas.isEmpty() ? new ArrayList<>() : contas; // Se não houver contas, retorna uma lista vazia
    }

    public ContaBancaria buscarContaPorNumero(Integer numeroConta) {
        BancoDigitalValidador.validarContaExistente(numeroConta, contas); // Validação se a conta existe
        return contas.stream()
                     .filter(conta -> conta.getNumeroConta().equals(numeroConta))
                     .findFirst()
                     .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada.")); // Caso não encontre
    }
}
