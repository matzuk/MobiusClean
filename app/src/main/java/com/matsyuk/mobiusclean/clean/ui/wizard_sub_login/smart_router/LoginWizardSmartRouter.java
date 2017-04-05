package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.smart_router;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.wizard_part.IAccountLoginWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.smart_router.LoginWizardStep.*;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class LoginWizardSmartRouter implements IInfoWizardPart, IAccountLoginWizardPart {

    private final Router router;
    private final ILoginWizardResult loginWizardResult;
    private LoginWizardStep loginWizardStep;

    public LoginWizardSmartRouter(Router router, LoginWizardStep loginWizardStep, ILoginWizardResult loginWizardResult) {
        this.router = router;
        this.loginWizardStep = loginWizardStep;
        this.loginWizardResult = loginWizardResult;
    }

    public void startWizard() {
        if (loginWizardStep != NONE) {
            return;
        }
        loginWizardStep = INFO;
        router.navigateTo(SUB_WIZARD_LOGIN_INFO_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        loginWizardStep = LOGIN;
        router.navigateTo(SUB_WIZARD_LOGIN_LOGIN_SCREEN);
    }

    @Override
    public void infoWizardBack() {
        loginWizardStep = NONE;
        router.finishChain();
    }

    /**
     * IAccountLoginWizardPart
     */

    @Override
    public void accountLoginWizardSuccess() {
        loginWizardStep = NONE;
        router.finishChain();
        loginWizardResult.onSuccess();
    }

    @Override
    public void accountLoginWizardBack() {
        loginWizardStep = NONE;
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
