package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.wizard_part.IAccountLoginWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class LoginWizardManager implements IInfoWizardPart, IAccountLoginWizardPart {

    private Router router;
    private ILoginWizardResult loginWizardResult;

    // TODO move to DI
    private LoginWizardState loginWizardState = new LoginWizardState(LoginStage.INFO);

    public LoginWizardManager(Router router, ILoginWizardResult loginWizardResult) {
        this.router = router;
        this.loginWizardResult = loginWizardResult;
        router.navigateTo(LOGIN_INFO_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        loginWizardState.setLoginStage(LoginStage.LOGIN);
        router.navigateTo(LOGIN_ACTIVATION_SCREEN);
    }

    @Override
    public void infoWizardBack() {
        router.finishChain();
    }

    /**
     * IAccountLoginWizardPart
     */

    @Override
    public void accountLoginWizardSuccess() {
        router.finishChain();
        loginWizardResult.onSuccess();
    }

    @Override
    public void accountLoginWizardBack() {
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
