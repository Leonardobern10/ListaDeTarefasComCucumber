package com.example.DesafioComNovasTechs.validations;

import com.example.DesafioComNovasTechs.exceptions.IdInvalidException;
import com.example.DesafioComNovasTechs.messages.ErrorMessages;

public class CheckIdIsValid {
    public static void validate (int counter, int id) {
        if (id > counter) {
            throw new IdInvalidException(ErrorMessages.UNEXIST_TAKS_WITH_THIS_ID_ERROR + id);
        }
    }
}
