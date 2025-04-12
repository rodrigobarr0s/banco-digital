# Banco Digital - Sistema de Gerenciamento de Contas Bancárias

Este é um sistema bancário desenvolvido em Java que segue a arquitetura **MVC (Model-View-Controller)** e o paradigma de **Programação Orientada a Objetos (POO)**. O sistema permite a criação de contas bancárias, realização de depósitos, saques e transferências, além de gerar extratos e aplicar rendimentos para contas poupança.

---

## Funcionalidades

### 1. **Gestão de Contas Bancárias**
   - Adicionar novas contas (`Conta Corrente` e `Conta Poupança`).
   - Listar todas as contas cadastradas.
   - Buscar contas pelo número.

### 2. **Operações Bancárias**
   - **Depósito**: Permite adicionar saldo à conta.
   - **Saque**: Permite retirar valor da conta (considerando limites como o cheque especial).
   - **Transferência**: Permite transferir valores entre contas bancárias.
   - **Rendimento de Conta Poupança**: Aplica rendimento automático na conta poupança (0,5% ao mês).

### 3. **Validações e Logs**
   - Validações de entrada de valores.
   - Verificação de saldo suficiente para saques e transferências.
   - Geração de logs detalhados para cada operação.

---

## Arquitetura

### POO (Programação Orientada a Objetos)

O sistema foi desenvolvido utilizando **POO**, com as principais classes modelando entidades do banco como objetos. Alguns dos princípios da POO aplicados incluem:

- **Encapsulamento**: Os dados, como saldo e número da conta, são encapsulados em métodos específicos de cada classe, garantindo acesso controlado.
- **Herança**: `ContaBancaria` é a classe base, enquanto `ContaCorrente` e `ContaPoupanca` são subclasses que herdam seus atributos e métodos, implementando comportamentos específicos, como saque e rendimento.
- **Polimorfismo**: Métodos, como `sacar()`, possuem comportamentos diferentes dependendo do tipo de conta.
- **Abstração**: Classes utilitárias, como `TransacaoValidador`, abstraem a lógica de validação de transações.

### MVC (Model-View-Controller)

A arquitetura **MVC** organiza o sistema em três camadas, separando as responsabilidades de dados, visualização e controle de fluxo:

- **Model (Modelo)**: Representa a lógica de negócios e manipulação de dados. Contém as classes `ContaBancaria`, `ContaCorrente`, `ContaPoupanca` e os serviços de operações bancárias.
- **View (Visão)**: Exibe os dados ao usuário, no console neste caso. Uma versão futura poderia incluir uma interface gráfica ou web.
- **Controller (Controlador)**: Gerencia a interação entre a visão e o modelo. As classes `BancoDigitalController` e `ContaBancariaController` coordenam as operações de entrada do usuário e atualizam a visualização.

---

## Tecnologias Utilizadas

- **Java**: A linguagem de programação principal.
- **Exception Handling**: Para tratar erros e exceções de maneira robusta.
- **Logging**: Utilização de logs para registrar operações e erros do sistema.
- **Java Collections**: Listas para armazenar as contas bancárias.

---

## Estrutura do Projeto

Abaixo está a estrutura geral do seu projeto:

```
├── application
│   └── AppBancoDigital.java
├── controller
│   ├── BancoDigitalController.java
│   └── ContaBancariaController.java
├── model
│   ├── entities
│   │   ├── ContaBancaria.java
│   │   ├── ContaCorrente.java
│   │   ├── ContaPoupanca.java
│   │   └── Cliente.java
│   ├── exceptions
│   │   ├── ContaNaoEncontradaException.java
│   │   ├── ContaNulaException.java
│   │   ├── SaldoInsuficienteException.java
│   │   ├── ValorNegativoException.java
│   │   └── ValorNuloException.java
│   ├── services
│   │   ├── BancoDigitalService.java
│   │   ├── NomeAleatorioService.java
│   │   └── OperacoesBancariasServices.java
│   └── utils
│       ├── BancoDigitalValidador.java
│       ├── Log.java
│       ├── TransacaoValidador.java
│       └── ContaBancariaFormatter.java
└── view
    └── ContaBancariaFormatter.java
```

### Principais classes:
- **ContaBancaria**: Classe base para todos os tipos de contas bancárias.
- **ContaCorrente**: Implementa uma conta corrente com limite de cheque especial.
- **ContaPoupanca**: Implementa uma conta poupança com rendimento mensal.
- **OperacoesBancariasServices**: Gerencia as operações de depósito, saque e transferência.
- **BancoDigitalController**: Controlador de operações do banco digital (adicionar, listar e buscar contas).

---

## Como Rodar o Projeto

### Pré-requisitos
- **JDK 8 ou superior** instalado na sua máquina.

### Passos para rodar o sistema:

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/seu-usuario/banco-digital.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd banco-digital
   ```

3. Compile o projeto:
   ```bash
   javac application/AppBancoDigital.java
   ```

4. Execute o projeto:
   ```bash
   java application.AppBancoDigital
   ```

5. O sistema exibirá o comportamento de contas bancárias e operações no console.

---

## Exemplos de Uso

### Criando uma Conta e Realizando Operações
Ao rodar o sistema, você verá uma sequência de operações simuladas:

1. **Criando contas bancárias** (uma Conta Corrente e uma Conta Poupança).
2. **Realizando depósitos** nas contas.
3. **Realizando saques** de valores.
4. **Transferindo valores** entre contas.
5. **Aplicando rendimento** na Conta Poupança.

Exemplo de output no console:

```
=== Extrato Conta Corrente ===
Agencia: 0001
Numero da conta: 1
Titular: Luna Souza
Saldo: R$ 800.00
==============================

=== Extrato Conta Poupança ===
Agencia: 0001
Numero da conta: 2
Titular: Theo Costa
Saldo: R$ 505.00
==============================
```

---

## Como Contribuir

1. Faça um fork deste repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Faça suas alterações e commit as mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

---

## Licença

Este projeto é licenciado sob a MIT License - consulte o arquivo [LICENSE](https://github.com/rodrigobarr0s/banco-digital?tab=MIT-1-ov-file) para mais detalhes.

---

## Autores

- **Rodrigo Barros**: [GitHub](https://github.com/rodrigobarr0s)