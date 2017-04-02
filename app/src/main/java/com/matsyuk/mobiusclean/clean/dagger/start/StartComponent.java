package com.matsyuk.mobiusclean.clean.dagger.start;

import com.matsyuk.mobiusclean.clean.ui.start_wizard.views.StartActivity;
import com.matsyuk.mobiusclean.clean.ui.start_wizard.views.StartInfoFragment;
import com.matsyuk.mobiusclean.clean.ui.start_wizard.views.StartLicenseFragment;

import dagger.Subcomponent;

/**
 * @author e.matsyuk
 */
@StartScope
@Subcomponent(modules = {StartWizardModule.class, StartNavigationModule.class})
public interface StartComponent {

    @Subcomponent.Builder
    interface Builder {
        StartComponent build();
    }

    void inject(StartActivity startActivity);
    void inject(StartInfoFragment startInfoFragment);
    void inject(StartLicenseFragment startLicenseFragment);

}
