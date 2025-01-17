package com.example.DesafioComNovasTechs.validations.InfoTarefa;

import com.example.DesafioComNovasTechs.exceptions.StringInvalidException;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;

public class StringInfoValidation extends StrategyValidationInfoTarefa {
    @Override
    public void validate (String string) {
        if (string.isBlank()) {
            throw new StringInvalidException(ErrorMessages.STRING_INFO_ERROR + string);
        }
    }
}
