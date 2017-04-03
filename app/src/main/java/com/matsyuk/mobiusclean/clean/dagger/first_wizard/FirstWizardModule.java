package com.matsyuk.mobiusclean.clean.dagger.first_wizard;

import com.matsyuk.mobiusclean.clean.ui.first_wizard.managers.FirstWizardManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.ActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.InfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.first_wizard.FirstWizardConstants.*;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType.*;

/**
 * @author e.matsyuk
 */
@Module
public class FirstWizardModule {

    /**
     * Managers
     */

    @WizardScope
    @Provides
    public FirstWizardManager provideStartWizardManager(@Named(FIRST_NAMED_ANNOTATION) Router router) {
        return new FirstWizardManager(router);
    }

    /**
     * Presenters
     */

    @WizardScope
    @Provides
    @Named(FIRST_INFO_START_NAMED_ANNOTATION)
    public IInfoPresenter provideInfoPresenterStart(FirstWizardManager firstWizardManager) {
        return new InfoPresenter(firstWizardManager, START);
    }

    @WizardScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public ILicensePresenter provideLicensePresenter(FirstWizardManager firstWizardManager) {
        return new LicensePresenter(firstWizardManager);
    }

    @WizardScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public IActivationPresenter provideActivationPresenter(FirstWizardManager firstWizardManager) {
        return new ActivationPresenter(firstWizardManager);
    }

    @WizardScope
    @Provides
    @Named(FIRST_INFO_FINISH_NAMED_ANNOTATION)
    public IInfoPresenter provideInfoPresenterFinish(FirstWizardManager firstWizardManager) {
        return new InfoPresenter(firstWizardManager, FINISH);
    }

}
