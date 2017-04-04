package com.matsyuk.mobiusclean.clean.ui.wizard_first.views;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.LicenseFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.FIRST_NAMED_ANNOTATION;


/**
 * @author e.matsyuk
 */
public class FirstLicenseFragment extends LicenseFragment {

    @Inject
    @Named(FIRST_NAMED_ANNOTATION)
    ILicensePresenter licensePresenter;

    @Override
    public void onResume() {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onResume();
    }

    @Override
    protected ILicensePresenter getPresenter() {
        return licensePresenter;
    }

}
