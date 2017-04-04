package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.wizard_part.IAccountLoginWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class LoginWizardManager implements IInfoWizardPart, IAccountLoginWizardPart {

    private final Router router;
    private final ILoginWizardResult loginWizardResult;
    private final LoginWizardState loginWizardState;

    public LoginWizardManager(Router router, LoginWizardState loginWizardState, ILoginWizardResult loginWizardResult) {
        this.router = router;
        this.loginWizardState = loginWizardState;
        this.loginWizardResult = loginWizardResult;
    }

    public void startWizard() {
        if (loginWizardState.getLoginStage() != LoginStage.NONE) {
            return;
        }
        loginWizardState.setLoginStage(LoginStage.INFO);
        router.navigateTo(SUB_WIZARD_LOGIN_INFO_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        loginWizardState.setLoginStage(LoginStage.LOGIN);
        router.navigateTo(SUB_WIZARD_LOGIN_LOGIN_SCREEN);
    }

    @Override
    public void infoWizardBack() {
        loginWizardState.setLoginStage(LoginStage.NONE);
        router.finishChain();
    }

    /**
     * IAccountLoginWizardPart
     */

    @Override
    public void accountLoginWizardSuccess() {
        loginWizardState.setLoginStage(LoginStage.NONE);
        router.finishChain();
        loginWizardResult.onSuccess();
    }

    @Override
    public void accountLoginWizardBack() {
        loginWizardState.setLoginStage(LoginStage.NONE);
        router.finishChain();
        loginWizardResult.onBack();
    }

    @Override
    public void accountLoginWizardForgot() {

    }

    @Override
    public void accountLoginWizardNewAccount() {

    }

}
