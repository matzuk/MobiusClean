package com.matsyuk.mobiusclean.clean.dagger.wizard_first;

import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstActivationFragment;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstActivity;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstInfoFinishFragment;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstInfoStartFragment;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstLicenseFragment;

import dagger.Subcomponent;

/**
 * @author e.matsyuk
 */
@WizardScope
@Subcomponent(modules = {FirstWizardModule.class, FirstNavigationModule.class})
public interface FirstComponent {

    @Subcomponent.Builder
    interface Builder {
        FirstComponent build();
    }

    void inject(FirstActivity firstActivity);
    void inject(FirstInfoStartFragment firstInfoStartFragment);
    void inject(FirstLicenseFragment firstLicenseFragment);
    void inject(FirstActivationFragment firstActivationFragment);
    void inject(FirstInfoFinishFragment firstInfoFinishFragment);

}
