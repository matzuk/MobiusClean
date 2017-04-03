package com.matsyuk.mobiusclean.clean.dagger.first_wizard;

import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstActivationFragment;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstActivity;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstInfoFragment;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstLicenseFragment;

import dagger.Subcomponent;

/**
 * @author e.matsyuk
 */
@FirstScope
@Subcomponent(modules = {FirstWizardModule.class, FirstNavigationModule.class})
public interface FirstComponent {

    @Subcomponent.Builder
    interface Builder {
        FirstComponent build();
    }

    void inject(FirstActivity firstActivity);
    void inject(FirstInfoFragment firstInfoFragment);
    void inject(FirstLicenseFragment firstLicenseFragment);
    void inject(FirstActivationFragment firstActivationFragment);

}
