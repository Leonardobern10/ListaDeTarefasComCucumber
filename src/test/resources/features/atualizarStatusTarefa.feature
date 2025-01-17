Feature: Atualização de tarefas já existentes

  Scenario Outline: Atualizar status da tarefa
    Given que eu tenho uma lista criada
    And tem uma tarefa com titulo <tituloRecebido>
    And tem uma tarefa com descricao <descricaoRecebida>
    And tem uma tarefa com status <statusRecebido>
    And a tarefa esta cadastrada na lista
    When eu quero atualizar o status de uma tarefa passando seu ID <idEsperado> e status <statusAtualizado>
    Then seu status passa a ser <statusAtualizado>
    Examples:
    | tituloRecebido | descricaoRecebida | statusRecebido  | idEsperado | statusAtualizado |
    | "titulo teste" | "descricao teste" | "em andamento"  |     1      | "concluido"      |
    | "titulo teste" | "descricao teste" | "concluido"     |     1      |  "nao concluido" |