package com.matsyuk.mobiusclean.clean.dagger.wizards_sub_login;

import com.matsyuk.mobiusclean.clean.business.auth.IAuthInteractor;
import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers.ILoginWizardResult;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers.LoginWizardManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.AccountLoginPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.IAccountLoginPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.InfoPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.LOGIN_NAMED_ANNOTATION;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType.LOGIN;

/**
 * @author e.matsyuk
 */
@Module
public class LoginWizardModule {

    /**
     * Managers
     */

    @WizardScope
    @Provides
    public LoginWizardManager provideLoginWizardManager(@Named(LOGIN_NAMED_ANNOTATION) Router router,
                                                        ILoginWizardResult loginWizardResult) {
        return new LoginWizardManager(router, loginWizardResult);
    }

    /**
     * Presenters
     */

    @WizardScope
    @Provides
    @Named(LOGIN_NAMED_ANNOTATION)
    public IInfoPresenter provideLoginInfoPresenter(LoginWizardManager loginWizardManager) {
        return new InfoPresenter(loginWizardManager, LOGIN);
    }

    @WizardScope
    @Provides
    @Named(LOGIN_NAMED_ANNOTATION)
    public IAccountLoginPresenter provideAccountLoginPresenter(LoginWizardManager loginWizardManager, IAuthInteractor authInteractor) {
        return new AccountLoginPresenter(loginWizardManager, authInteractor);
    }

}
