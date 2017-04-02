package com.matsyuk.mobiusclean.clean.dagger.start;

import com.matsyuk.mobiusclean.clean.ui.start_wizard.managers.StartWizardManager;
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

import static com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType.*;

/**
 * @author e.matsyuk
 */
@Module
public class StartWizardModule {

    @StartScope
    @Provides
    public StartWizardManager provideStartWizardManager(@Named("start_wizard") Router router) {
        return new StartWizardManager(router);
    }

    @StartScope
    @Provides
    @Named("start_wizard")
    public IInfoWizardPart provideInfoWizardPart(Lazy<StartWizardManager> startWizardManagerLazy) {
        return startWizardManagerLazy.get();
    }

    @StartScope
    @Provides
    @Named("start_wizard")
    public ILicenseWizardPart provideLicenseWizardPart(Lazy<StartWizardManager> startWizardManagerLazy) {
        return startWizardManagerLazy.get();
    }

    @StartScope
    @Provides
    @Named("start_wizard_start")
    public IInfoPresenter provideInfoPresenter(@Named("start_wizard") IInfoWizardPart wizardPart) {
        return new InfoPresenter(wizardPart, START);
    }

    @StartScope
    @Provides
    @Named("start_wizard")
    public ILicensePresenter provideLicensePresenter(@Named("start_wizard") ILicenseWizardPart wizardPart) {
        return new LicensePresenter(wizardPart);
    }

}
