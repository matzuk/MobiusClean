package com.matsyuk.mobiusclean.clean.dagger.wizard_first;

import com.matsyuk.mobiusclean.clean.business.first_wizard.FirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router.FirstWizardStep;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router.FirstWizardSmartRouter;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.smart_router.ILoginWizardResult;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.ActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.InfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

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
    FirstWizardSmartRouter provideStartWizardManager(@Named(FIRST_NAMED_ANNOTATION) Router router) {
        return new FirstWizardSmartRouter(router, FirstWizardStep.NONE);
    }

    /**
     * Listeners for children
     */

    @WizardScope
    @Provides
    ILoginWizardResult provideLoginWizardResult(Lazy<FirstWizardSmartRouter> firstWizardManagerLazy) {
        return firstWizardManagerLazy.get();
    }

    /**
     * Interactors
     */

    @WizardScope
    @Provides
    IFirstWizardInteractor provideFirstWizardInteractor() {
        return new FirstWizardInteractor();
    }

    /**
     * Wizard parts
     */

    @WizardScope
    @Provides
    @Named(FIRST_INFO_START_NAMED_ANNOTATION)
    IInfoWizardPart provideIInfoWizardPartStart(Lazy<FirstWizardSmartRouter> firstWizardSmartRouterLazy) {
        return firstWizardSmartRouterLazy.get();
    }

    @WizardScope
    @Provides
    ILicenseWizardPart provideILicenseWizardPart(Lazy<FirstWizardSmartRouter> firstWizardSmartRouterLazy) {
        return firstWizardSmartRouterLazy.get();
    }

//    @WizardScope
//    @Provides
//    IActivationWizardPart provideIActivationWizardPart(Lazy<FirstWizardSmartRouter> firstWizardSmartRouterLazy) {
//        return firstWizardSmartRouterLazy.get();
//    }

    @WizardScope
    @Provides
    @Named(FIRST_INFO_FINISH_NAMED_ANNOTATION)
    IInfoWizardPart provideIInfoWizardPartFinish(Lazy<FirstWizardSmartRouter> firstWizardSmartRouterLazy) {
        return firstWizardSmartRouterLazy.get();
    }

    /**
     * Presenters
     */

    @WizardScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    IActivationPresenter provideActivationPresenter(FirstWizardSmartRouter firstWizardSmartRouter) {
        return new ActivationPresenter(firstWizardSmartRouter);
    }

}
