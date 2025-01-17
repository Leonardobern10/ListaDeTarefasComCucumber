package com.example.DesafioComNovasTechs.validations.InfoTarefa;

public class ContextValidationTarefa {
    private final StrategyValidationInfoTarefa strategy;

    public ContextValidationTarefa (StrategyValidationInfoTarefa strategy) {
        this.strategy = strategy;
    }

    public void validate (String string) {
        this.strategy.validate(string);
    }
}
