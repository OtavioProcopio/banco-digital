# Abstração de um Banco Digital

## Visão Geral
Este projeto simula a abstração de um banco digital. Ele foi desenvolvido como parte de um desafio proposto pela Dio, e implementa funcionalidades básicas de um sistema bancário, como cadastro de clientes, criação de contas e manipulação de arquivos para armazenar informações.

## Estrutura do Projeto
O projeto foi estruturado em diferentes classes e interfaces, cada uma com uma responsabilidade clara. A seguir, a descrição dos principais componentes:

### 1. **Classe `App`**
Esta classe contém o método principal `main` e é responsável por gerenciar a interação com o usuário por meio de um menu de opções. As principais funcionalidades incluem:
- **Cadastro de novos clientes e contas:**
  - Cria uma `Conta Corrente` e uma `Conta Poupança` para cada cliente.
  - Salva as informações do cliente em um arquivo chamado `Clientes.txt`.
  - Salva as informações das contas no arquivo `Contas.txt`.
- **Exibição de clientes cadastrados:**
  - Lê os dados do arquivo `Clientes.txt` e os exibe no console.
- **Manipulação de arquivos:**
  - Criação dos arquivos de clientes e contas.
  - Persistência de dados para reutilização futura.

### 2. **Classe `Cliente`**
Representa as informações de um cliente, como:
- Nome
- Email
- Telefone
- Idade

Esta classe inclui métodos de acesso (getters e setters) e uma sobrescrita do método `toString` para exibir os detalhes do cliente.

### 3. **Classe Abstrata `Conta`**
Define os atributos e comportamentos comuns às contas bancárias:
- **Atributos:**
  - Agência
  - Número da conta
  - Saldo
  - Cliente associado
- **Métodos comuns:**
  - Saque
  - Depósito
  - Transferência
  - Impressão de informações básicas da conta

### 4. **Classes `ContaCorrente` e `ContaPoupanca`**
São especializações da classe `Conta` que implementam características específicas:
- Sobrescrita do método `imprimirExtrato` para exibir detalhes específicos de cada tipo de conta.
- Sobrescrita do método `toString` para personalizar a exibição dos dados.

### 5. **Interface `IConta`**
Define os comportamentos esperados para qualquer tipo de conta bancária:
- Saque
- Depósito
- Transferência
- Impressão do extrato

## Funcionamento do Sistema
O sistema opera em um loop baseado em menu, permitindo que o usuário escolha entre as opções disponíveis:
1. **Novo Cadastro:**
   - Solicita os dados do cliente.
   - Cria uma `Conta Corrente` e uma `Conta Poupança` associadas ao cliente.
   - Armazena os dados em arquivos.

2. **Exibir Clientes:**
   - Lê os dados armazenados no arquivo `Clientes.txt` e os exibe.

3. **Sair:**
   - Encerra o programa.

## Persistência de Dados
Os dados de clientes e contas são salvos em arquivos de texto para garantir que as informações sejam mantidas mesmo após o encerramento do programa:
- **Clientes:**
  - Arquivo `Clientes.txt` contém informações dos clientes, separadas por vírgulas.
- **Contas:**
  - Arquivo `Contas.txt` contém informações das contas criadas para cada cliente.

## Exemplo de Execução
### Cadastro de Cliente:
```text
Digite o nome do cliente: João
Digite o e-mail do cliente: joao@email.com
Digite o telefone do cliente: 123456789
Digite a idade do cliente: 30
Contas criadas com sucesso para João
Conta Corrente - Número: 1
Conta Poupança - Número: 2
```

### Exibição de Clientes:
```text
Cliente{nome='João', email='joao@email.com', telefone='123456789', idade=30}
```

## Melhorias Futuras
- Implementação de autenticação para acesso ao sistema.
- Adição de operações bancárias como pagamento de boletos e investimentos.
- Integração com banco de dados para maior robustez e escalabilidade.
- Interface gráfica ou API para tornar o sistema mais acessível aos usuários.
