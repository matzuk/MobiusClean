package com.matsyuk.mobiusclean.clean.dagger.first_wizard;

import com.matsyuk.mobiusclean.clean.ui.first_wizard.managers.FirstWizardManager;
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

    @FirstScope
    @Provides
    public FirstWizardManager provideStartWizardManager(@Named(FIRST_NAMED_ANNOTATION) Router router) {
        return new FirstWizardManager(router);
    }

    /**
     * Wizard parts
     */

    @FirstScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public IInfoWizardPart provideInfoWizardPart(Lazy<FirstWizardManager> startWizardManagerLazy) {
        return startWizardManagerLazy.get();
    }

    @FirstScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public ILicenseWizardPart provideLicenseWizardPart(Lazy<FirstWizardManager> startWizardManagerLazy) {
        return startWizardManagerLazy.get();
    }

    @FirstScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public IActivationWizardPart provideActivationWizardPart(Lazy<FirstWizardManager> startWizardManagerLazy) {
        return startWizardManagerLazy.get();
    }

    /**
     * Presenters
     */

    @FirstScope
    @Provides
    @Named(FIRST_INFO_START_NAMED_ANNOTATION)
    public IInfoPresenter provideInfoPresenter(@Named(FIRST_NAMED_ANNOTATION) IInfoWizardPart wizardPart) {
        return new InfoPresenter(wizardPart, START);
    }

    @FirstScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public ILicensePresenter provideLicensePresenter(@Named(FIRST_NAMED_ANNOTATION) ILicenseWizardPart wizardPart) {
        return new LicensePresenter(wizardPart);
    }

    @FirstScope
    @Provides
    @Named(FIRST_NAMED_ANNOTATION)
    public IActivationPresenter provideActivationPresenter(@Named(FIRST_NAMED_ANNOTATION) IActivationWizardPart wizardPart) {
        return new ActivationPresenter(wizardPart);
    }

}
