package com.example.DesafioComNovasTechs.service;

import com.example.DesafioComNovasTechs.exceptions.*;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;
import com.example.DesafioComNovasTechs.model.*;
import com.example.DesafioComNovasTechs.validations.CheckIdIsValid;
import com.example.DesafioComNovasTechs.validations.CheckStringInfo;
import com.example.DesafioComNovasTechs.validations.CheckTarefaIsNull;
import com.example.DesafioComNovasTechs.validations.DescriptionStatusValidation;
import com.example.DesafioComNovasTechs.validations.InfoTarefa.ContextValidationTarefa;

public class ListaService {

    private int counter = 0;
    private final ListaTarefa listaTarefa = new ListaTarefa();

    public void adicionarTarefa (String titulo, String description, StatusTarefa statusTarefa) {
        try {
            CheckStringInfo.check(titulo, description);
            ContextValidationTarefa contextValidationTarefa = new ContextValidationTarefa(new DescriptionStatusValidation());
            contextValidationTarefa.validate(description);
            counter += 1;
            listaTarefa.getContent().put(counter, new Tarefa(titulo, description, statusTarefa));
        } catch ( DescriptionStatusInvalidException | StringInvalidException | StatusInvalidException e) {

            if ( e.getClass().equals(StatusInvalidException.class) ) {
                throw new StatusInvalidException(ErrorMessages.UNEXIST_STATUS_ERROR + e.getMessage());
            }
            if (e.getClass().equals(DescriptionStatusInvalidException.class)) {
                throw new DescriptionStatusInvalidException(ErrorMessages.NULL_DESCRIPTION_STATUS_ERROR + e.getMessage());
            }

            throw new StringInvalidException(ErrorMessages.STRING_INFO_ERROR + e.getMessage());
        }
    }

    public void changeStatusTarefa (StatusTarefa statusTarefa, Integer id) {
        try {
            Tarefa tarefa = searchTarefaToId(id);
            if (tarefa.getStatusTarefa() == statusTarefa) {
                System.out.printf("A tarefa com ID: %d já tem esse STATUS: %s",
                        id, statusTarefa);
                return;
            }
            StrategyTarefa strategyTarefa = StrategyTarefaFactory.strategyTarefa(statusTarefa);
            ContextTarefa contextTarefa1 = new ContextTarefa(strategyTarefa);
            contextTarefa1.changeTarefaStatus(tarefa);
        } catch ( StatusInvalidException | IdInvalidException e ) {
            if (e.getClass().equals(IdInvalidException.class)) {
                throw new IdInvalidException(ErrorMessages.UNEXIST_TAKS_WITH_THIS_ID_ERROR + e.getMessage());
            }
            throw new StatusInvalidException(ErrorMessages.NULL_DESCRIPTION_STATUS_ERROR + e.getMessage());
        }
    }

    private Tarefa searchTarefa (Integer id) {
        return listaTarefa.getContent().get(id);
    }

    public void removerTarefa (int idRemocao) {
        try {
            searchTarefaToId(idRemocao);
            listaTarefa.getContent().remove(idRemocao);
        } catch ( IdInvalidException | TarefaNullException e ) {
            if ( e.getClass() == IdInvalidException.class ) {
                throw new IdInvalidException(ErrorMessages.UNEXIST_TAKS_WITH_THIS_ID_ERROR + e.getMessage());
            }
            throw new TarefaNullException(ErrorMessages.UNEXIST_TAKS_WITH_THIS_ID_ERROR + e.getMessage());
        }
    }

    private Tarefa searchTarefaToId (int id) throws IdInvalidException, TarefaNullException {
        CheckIdIsValid.validate(counter, id);
        Tarefa tarefa = searchTarefa(id);
        CheckTarefaIsNull.isNull(tarefa, id);
        return listaTarefa.getContent().get(id);
    }

    public int getSize () {
        return listaTarefa.getContent().size();
    }

    public Tarefa getTarefa (int id) {
        return listaTarefa.getContent().get(id);
    }
}
