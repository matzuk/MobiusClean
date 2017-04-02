package com.matsyuk.mobiusclean.clean.ui.start_wizard.managers;

/**
 * @author e.matsyuk
 */
public class StartState {

    private StartStage startStage;

    public StartState(StartStage startStage) {
        this.startStage = startStage;
    }

    public void setStartStage(StartStage startStage) {
        this.startStage = startStage;
    }

    public StartStage getStartStage() {
        return startStage;
    }

}
