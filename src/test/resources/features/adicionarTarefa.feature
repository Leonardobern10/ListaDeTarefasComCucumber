Feature: Lista de tarefas

  Scenario Outline: Adicionar tarefa com dados válidos
    Given que eu tenho uma lista criada
    And eu informo um titulo <tituloRecebido>
    And eu envio uma string <descricaoRecebida> para descricao
    And eu defino um status <statusRecebido>
    When eu chamo o metodo criar tarefa
    Then uma nova tarefa e adicionada na lista
    And o titulo da tarefa e <tituloRecebido>
    And a descricao da tarefa e <descricaoRecebida>
    And o status da tarefa e <statusRecebido>
    Examples:
      | tituloRecebido    | descricaoRecebida                      | statusRecebido |
      | "Primeira Tarefa" | "Esta tarefa trata da primeira tarefa" | "em andamento" |

    Scenario Outline: Erro ao tentar adicionar tarefa com título inválido
      Given que eu tenho uma lista criada
      When eu informo um titulo invalido <tituloRecebido>
      And e uma descricao <descricaoRecebida>
      And e status <statusRecebido>
      Then eu recebo um erro do tipo titulo invalido
      And nenhuma tarefa e adicionada
      Examples:
        | tituloRecebido  | descricaoRecebida | statusRecebido |
        | " " | "descricao teste"             | "concluido"  |
        | "" | "descricao teste"              | "em andamento"  |


  Scenario Outline: Erro ao tentar adicionar tarefa com descricao inválida
    Given que eu tenho uma lista criada
    When eu informo um titulo <tituloRecebido>
    And e uma descricao invalida <descricaoRecebida>
    And e status <statusRecebido>
    Then eu recebo um erro do tipo descricao invalida
    And nenhuma tarefa e adicionada
    Examples:
      | tituloRecebido  | descricaoRecebida | statusRecebido  |
      | "titulo test"   | " "               | "concluido"     |
      | "titulo test"   | ""                | "em andamento"  |


  Scenario Outline: Erro ao tentar adicionar tarefa com status invalido
    Given que eu tenho uma lista criada
    When eu informo um titulo <tituloRecebido>
    And e uma descricao <descricaoRecebida>
    And ao inserir um status <statusRecebido> recebo um erro de status invalido
    And nenhuma tarefa e adicionada
    Examples:
      | tituloRecebido  | descricaoRecebida | statusRecebido  |
      | "titulo test"   | "descricao test"  | ""     |
      | "titulo test"   | "descricao test"  | " "     |

  Scenario Outline: Erro ao tentar adicionar tarefa com status inexistente
    Given que eu tenho uma lista criada
    When eu informo um titulo <tituloRecebido>
    And e uma descricao <descricaoRecebida>
    And ao inserir um status <statusRecebido> recebo um erro de status inexistente
    And nenhuma tarefa e adicionada
    Examples:
      | tituloRecebido  | descricaoRecebida | statusRecebido  |
      | "titulo test"   | "descricao test"  | "andamento"     |
      | "titulo test"   | "descricao test"  | "feito"     |