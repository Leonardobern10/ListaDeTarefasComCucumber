package com.example.DesafioComNovasTechs.validations;

import com.example.DesafioComNovasTechs.validations.InfoTarefa.ContextValidationTarefa;
import com.example.DesafioComNovasTechs.validations.InfoTarefa.StringInfoValidation;

import java.util.List;

public class CheckStringInfo {
    public static void check (String titulo, String descricao) {
        ContextValidationTarefa context = new ContextValidationTarefa(new StringInfoValidation());
        List.of(titulo, descricao).forEach(context::validate);
    }
}
