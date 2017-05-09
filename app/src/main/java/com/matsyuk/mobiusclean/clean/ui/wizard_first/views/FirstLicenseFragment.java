package com.matsyuk.mobiusclean.clean.ui.wizard_first.views;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.LicenseFragment;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.FIRST_NAMED_ANNOTATION;


/**
 * @author e.matsyuk
 */
public class FirstLicenseFragment extends LicenseFragment {

    @Inject
    ILicenseWizardPart licenseWizardPart;

    @Inject
    IFirstWizardInteractor firstWizardInteractor;

    @ProvidePresenter
    LicensePresenter provideLicensePresenter() {
        return new LicensePresenter(licenseWizardPart, firstWizardInteractor);
    }

    @InjectPresenter
    LicensePresenter licensePresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ILicensePresenter getPresenter() {
        return licensePresenter;
    }

}
