package com.matsyuk.mobiusclean.clean.ui.first_wizard.managers;

/**
 * @author e.matsyuk
 */
public class FirstWizardState {

    private FirstWizardStage firstWizardStage;

    public FirstWizardState(FirstWizardStage firstWizardStage) {
        this.firstWizardStage = firstWizardStage;
    }

    public void setFirstWizardStage(FirstWizardStage firstWizardStage) {
        this.firstWizardStage = firstWizardStage;
    }

    public FirstWizardStage getFirstWizardStage() {
        return firstWizardStage;
    }

}
