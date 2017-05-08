package com.matsyuk.mobiusclean.clean.ui.wizard_first.views;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;
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
    LicensePresenter licensePresenterDagger;

    @ProvidePresenter
    LicensePresenter provideLicensePresenter() {
        return licensePresenterDagger;
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
