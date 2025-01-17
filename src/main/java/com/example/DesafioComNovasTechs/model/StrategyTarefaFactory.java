package com.example.DesafioComNovasTechs.model;

public class StrategyTarefaFactory {
    public static StrategyTarefa strategyTarefa (StatusTarefa statusTarefa) {
        return switch ( statusTarefa ) {
            case CONCLUIDO -> new TarefaConcluida();
            case EM_ANDAMENTO -> new TarefaEmAndamento();
            case NAO_CONCLUIDO -> new TarefaNaoConcluida();
            default -> throw new IllegalArgumentException("Status de tarefa não permitido!");
        };
    }
}
