package com.matsyuk.mobiusclean.clean.dagger.wizard_first;

import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;
import com.matsyuk.mobiusclean.clean.dagger.wizards_sub_login.LoginNavigationModule;
import com.matsyuk.mobiusclean.clean.dagger.wizards_sub_login.LoginWizardModule;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstActivationFragment;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstActivity;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstInfoFinishFragment;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstInfoStartFragment;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstLicenseFragment;
import com.matsyuk.mobiusclean.clean.ui.wizard_first.views.FirstLoginActivity;

import dagger.Subcomponent;

/**
 * @author e.matsyuk
 */
@WizardScope
@Subcomponent(modules = {FirstWizardModule.class, FirstNavigationModule.class,
        LoginWizardModule.class, LoginNavigationModule.class})
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
    void inject(FirstLoginActivity firstLoginActivity);

}
