package com.matsyuk.mobiusclean.clean.ui.wizard_first.managers;

/**
 * @author e.matsyuk
 */
public class FirstWizardState {

    private FirstStage firstStage;

    public FirstWizardState(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

}
