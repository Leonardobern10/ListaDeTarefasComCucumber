# Documentação do Projeto - DesafioComNovasTechs



## Sumário

1. [Introdução](#introdução)

2. [Estrutura do Projeto](#estrutura-do-projeto)

3. [Modelos](#modelos)

4. [Exceções](#exceções)

5. [Serviços](#serviços)

6. [Validações](#validações)

7. [Testes com Cucumber](#testes-com-cucumber)



---



## Introdução

Este projeto implementa uma aplicação para gerenciamento de tarefas utilizando estratégias de validação e mudança de status. Ele segue uma arquitetura modular para separar responsabilidades, facilitando manutenção e escalabilidade.



---



## Estrutura do Projeto

O projeto está organizado nas seguintes pastas principais:

- **exceptions**: Contém classes para tratamento de exceções customizadas.

- **model**: Define as classes principais como `Tarefa`, estratégias e enumeradores.

- **service**: Implementa a lógica de negócio para gerenciamento das tarefas.

- **validations**: Validações aplicadas em dados de entrada e tarefas.

- **steps**: Testes com Cucumber.



---



## Modelos

### ContextTarefa

Gerencia estratégias para mudança de status de uma tarefa.



### ListaTarefa

Estrutura de dados para armazenar tarefas usando `HashMap`.



### StatusTarefa

Enumeração com os possíveis status de uma tarefa:

- `CONCLUIDO`

- `EM_ANDAMENTO`

- `NAO_CONCLUIDO`



Inclui métodos para validação e conversão de descrições.



### Tarefa

Representa uma tarefa com as propriedades:

- `titulo` (String)

- `descricao` (String)

- `statusTarefa` (StatusTarefa)



### Estratégias de Mudança de Status

As estratégias são implementadas em classes concretas:

- **TarefaConcluida**: Altera o status para `CONCLUIDO`.

- **TarefaEmAndamento**: Altera o status para `EM_ANDAMENTO`.

- **TarefaNaoConcluida**: Altera o status para `NAO_CONCLUIDO`.



---



## Exceções

Exceções customizadas para diferentes cenários de erro:

- `DescriptionStatusInvalidException`: Lançada quando a descrição do status é inválida.

- `IdInvalidException`: Lançada quando o ID informado não é válido.

- `StatusInvalidException`: Lançada para status inválidos.

- `StringInvalidException`: Lançada para strings nulas ou vazias.

- `TarefaNullException`: Lançada quando uma tarefa é nula.

- `TitleInvalidException`: Lançada para títulos inválidos.



---



## Serviços

### ListaService

Serviço responsável pelo gerenciamento de tarefas, incluindo:

- **Adicionar Tarefa**: Valida entradas e adiciona uma nova tarefa à lista.

- **Alterar Status da Tarefa**: Modifica o status utilizando estratégias.

- **Remover Tarefa**: Remove uma tarefa pelo ID.



Métodos principais:

- `adicionarTarefa(String titulo, String description, StatusTarefa statusTarefa)`

- `changeStatusTarefa(StatusTarefa statusTarefa, Integer id)`

- `removerTarefa(int idRemocao)`



---



## Validações

### CheckIdIsValid

Valida IDs fornecidos.



### CheckStringInfo

Valida informações de strings (título e descrição).



### CheckTarefaIsNull

Verifica se uma tarefa é nula.



### DescriptionStatusValidation

Valida a descrição do status.



### ContextValidationTarefa

Implementa um padrão de estratégia para validações.



---



## Testes com Cucumber

Os testes do projeto utilizam a biblioteca **Cucumber** para validar as funcionalidades:

- Adicionar uma tarefa com diferentes cenários de entrada.

- Alterar o status de uma tarefa.

- Remover tarefas.



Os cenários são definidos com as anotações do Cucumber:

- `@Given`

- `@When`

- `@Then`

- `@And`



---



## Como Executar

1. Clone o repositório.

2. Configure as dependências no Maven.

3. Execute os testes com a suíte definida.



---



## Contribuições

Contribuições são bem-vindas! Siga as diretrizes de contribuição antes de enviar um PR.



---



## Licença

Este projeto está licenciado sob a licença MIT.

"""
