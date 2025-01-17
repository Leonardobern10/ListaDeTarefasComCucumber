package com.example.DesafioComNovasTechs.model;

public class ContextTarefa {
    private final StrategyTarefa strategyTarefa;

    public ContextTarefa (StrategyTarefa strategyTarefa) {
        this.strategyTarefa = strategyTarefa;
    }

    public void changeTarefaStatus (Tarefa tarefa) {
        this.strategyTarefa.changeStatus(tarefa);
    }
}
