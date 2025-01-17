package com.example.DesafioComNovasTechs.model;

public class TarefaNaoConcluida extends StrategyTarefa {
    @Override
    public void changeStatus (Tarefa tarefa) {
        tarefa.setStatusTarefa(StatusTarefa.NAO_CONCLUIDO);
    }
}
