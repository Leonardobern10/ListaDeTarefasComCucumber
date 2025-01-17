package com.example.DesafioComNovasTechs.validations;

import com.example.DesafioComNovasTechs.exceptions.TarefaNullException;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;
import com.example.DesafioComNovasTechs.model.Tarefa;

public class CheckTarefaIsNull {
    public static void isNull (Tarefa tarefa, int id) {
        if (tarefa == null) {
            throw new TarefaNullException(ErrorMessages.UNEXIST_TAKS_WITH_THIS_ID_ERROR + id);
        }
    }
}
