Feature: Lista de tarefa

  Scenario Outline: Remover uma tarefa
    Given que eu tenho uma lista criada
    And tem uma tarefa com titulo <tituloRecebido>
    And tem uma tarefa com descricao <descricaoRecebida>
    And tem uma tarefa com status <statusRecebido>
    And a tarefa esta cadastrada na lista
    When eu quero remover uma tarefa passando seu ID <idRemocao>
    Then a tarefa e removida da lista
    Examples:
    | tituloRecebido | descricaoRecebida   | statusRecebido  | idRemocao |
    | "titulo teste" | "descricaoRecebida" | "concluido"     |       1   |