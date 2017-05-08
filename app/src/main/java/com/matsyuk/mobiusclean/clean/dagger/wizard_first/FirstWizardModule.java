package com.matsyuk.mobiusclean.clean.dagger.wizard_first;

import com.matsyuk.mobiusclean.clean.business.first_wizard.FirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router.FirstWizardStep;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router.FirstWizardSmartRouter;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.smart_router.ILoginWizardResult;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.ActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.InfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;

import javax.inject.Named;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.*;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType.*;

/**
 * @author e.matsyuk
 */
@Module
public class FirstWizardModule {

    /**
     * Smart router
     */

    @WizardScope
    @Provides
    public FirstWizardSmartRouter provideStartWizardManager(@Named(FIRST_NAMED_ANNOTATION) Router router) {
        return new FirstWizardSmartRouter(router, FirstWizardStep.NONE);
    }

    /**
     * Listeners for children
     */

    @WizardScope
    @Provides
    public ILoginWizardResult provideLoginWizardResult(Lazy<FirstWizardSmartRouter> firstWizardManagerLazy) {
        return firstWizardManagerLazy.get();
    }

    /**
     * Interactors
     */

    @WizardScope
    @Provides
    public IFirstWizardInteractor provideFirstWizardInteractor() {
        return new FirstWizardInteractor();
    }

    /**
     * Presenters
     */

    @WizardScope
    @Provides
    @Named(FIRST_INFO_START_NAMED_ANNOTATION)
    public IInfoPresenter provideInfoPresenterStart(FirstWizardSmartRouter firstWizardSmartRouter) {
        return new InfoPresenter(firstWizardSmartRouter, START);
    }

    @WizardScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public LicensePresenter provideLicensePresenter(FirstWizardSmartRouter firstWizardSmartRouter, IFirstWizardInteractor firstWizardInteractor) {
        return new LicensePresenter(firstWizardSmartRouter, firstWizardInteractor);
    }

    @WizardScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public IActivationPresenter provideActivationPresenter(FirstWizardSmartRouter firstWizardSmartRouter) {
        return new ActivationPresenter(firstWizardSmartRouter);
    }

    @WizardScope
    @Provides
    @Named(FIRST_INFO_FINISH_NAMED_ANNOTATION)
    public IInfoPresenter provideInfoPresenterFinish(FirstWizardSmartRouter firstWizardSmartRouter) {
        return new InfoPresenter(firstWizardSmartRouter, FINISH);
    }

}
