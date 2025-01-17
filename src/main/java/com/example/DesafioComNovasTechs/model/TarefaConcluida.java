package com.example.DesafioComNovasTechs.model;

public class TarefaConcluida extends StrategyTarefa {
    @Override
    public void changeStatus (Tarefa tarefa) {
        tarefa.setStatusTarefa(StatusTarefa.CONCLUIDO);
    }
}
