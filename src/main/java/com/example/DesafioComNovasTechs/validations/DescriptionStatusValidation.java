package com.example.DesafioComNovasTechs.validations;

import com.example.DesafioComNovasTechs.exceptions.DescriptionStatusInvalidException;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;
import com.example.DesafioComNovasTechs.validations.InfoTarefa.StrategyValidationInfoTarefa;

public class DescriptionStatusValidation extends StrategyValidationInfoTarefa {
    public void validate (String description) {
        if (description == null || description.isBlank()) {
            throw new DescriptionStatusInvalidException(
                    ErrorMessages.NULL_DESCRIPTION_STATUS_ERROR + description);
        }
    }
}
