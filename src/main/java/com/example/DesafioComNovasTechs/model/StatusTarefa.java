package com.example.DesafioComNovasTechs.model;

import com.example.DesafioComNovasTechs.exceptions.DescriptionStatusInvalidException;
import com.example.DesafioComNovasTechs.exceptions.StatusInvalidException;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;
import com.example.DesafioComNovasTechs.validations.DescriptionStatusValidation;
import com.example.DesafioComNovasTechs.validations.InfoTarefa.ContextValidationTarefa;

public enum StatusTarefa {
    CONCLUIDO("concluido"),
    EM_ANDAMENTO("em andamento"),
    NAO_CONCLUIDO("nao concluido");

    private final String description;

    StatusTarefa (String description) {
        this.description = description;
    }

    public String getDescription () {
        return description;
    }

    public static StatusTarefa fromDescription(String description) throws StatusInvalidException, DescriptionStatusInvalidException {
        ContextValidationTarefa contextValidationTarefa = new ContextValidationTarefa(new DescriptionStatusValidation());
        contextValidationTarefa.validate(description);

        for (StatusTarefa status : values()) {
            if (status.getDescription().equalsIgnoreCase(description)) {
                return status;
            }
        }

        throw new StatusInvalidException(String.format(ErrorMessages.UNEXIST_STATUS_ERROR + description));
    }
}
