package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers;

/**
 * @author e.matsyuk
 */
public class LoginWizardState {

    private LoginStage loginStage;

    public LoginWizardState(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

    public LoginStage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

}
