package application;

import controller.BancoDigitalController;
import controller.ContaBancariaController;
import model.entities.ContaBancaria;
import model.entities.ContaCorrente;
import model.entities.ContaPoupança;
import view.ContaBancariaFormatter;

public class AppBancoDigital {

    public static void main(String[] args) {
        // Criando instâncias de controladores
        BancoDigitalController bancoDigitalController = new BancoDigitalController();
        ContaBancariaController contaBancariaController = new ContaBancariaController();

        // Criando contas
        ContaBancaria conta1 = new ContaCorrente(); // Conta Corrente
        ContaBancaria conta2 = new ContaPoupança();  // Conta Poupança

        // Adicionando as contas ao banco
        bancoDigitalController.adicionarConta(conta1);
        bancoDigitalController.adicionarConta(conta2);

        // Exibindo contas antes das operações
        System.out.println("\n=== Contas Criadas ===");
        System.out.println(ContaBancariaFormatter.formatterConta(conta1));
        System.out.println(ContaBancariaFormatter.formatterConta(conta2));

        System.out.println("\n--- Operações Bancárias ---\n");

        // Realizando depósitos
        contaBancariaController.realizarDeposito(conta1, 1500.0);  // Depósito na Conta Corrente
        contaBancariaController.realizarDeposito(conta2, 500.0);   // Depósito na Conta Poupança

        // Aplicando rendimento na Conta Poupança
        ((ContaPoupança) conta2).aplicarRendimento();  // Aplica o rendimento de 0,5%

        // Realizando saques
        contaBancariaController.realizarSaque(conta1, 200.0);  // Saque da Conta Corrente
        contaBancariaController.realizarSaque(conta2, 100.0);  // Saque da Conta Poupança

        // Realizando uma transferência
        contaBancariaController.realizarTransferencia(conta1, conta2, 300.0);  // Transferência de Conta Corrente para Conta Poupança

        // Exibindo as contas após as operações
        System.out.println("\n=== Extratos Finais ===");
        System.out.println(ContaBancariaFormatter.formatterExtrato(conta1));  // Exibindo extrato da Conta Corrente
        System.out.println(ContaBancariaFormatter.formatterExtrato(conta2));  // Exibindo extrato da Conta Poupança

        System.out.println("\n--- Listando todas as contas cadastradas ---");
        bancoDigitalController.listarContas();  // Listando todas as contas no banco

        // Testando busca por número da conta
        System.out.println("\n--- Buscando Conta pelo Número ---");
        bancoDigitalController.buscarContaPorNumero(conta1.getNumeroConta());  // Buscando a Conta Corrente pelo número
        bancoDigitalController.buscarContaPorNumero(conta2.getNumeroConta());  // Buscando a Conta Poupança pelo número

        // Realizando mais uma transferência para testar o saldo insuficiente
        System.out.println("\n--- Testando Transferência com Saldo Insuficiente ---");
        contaBancariaController.realizarTransferencia(conta2, conta1, 1000.0);  // Tentando transferir mais do que o saldo
    }
}
