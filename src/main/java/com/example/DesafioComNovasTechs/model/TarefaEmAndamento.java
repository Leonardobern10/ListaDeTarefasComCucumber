package com.example.DesafioComNovasTechs.model;

public class TarefaEmAndamento extends StrategyTarefa {
    @Override
    public void changeStatus (Tarefa tarefa) {
        tarefa.setStatusTarefa(StatusTarefa.EM_ANDAMENTO);
    }
}
