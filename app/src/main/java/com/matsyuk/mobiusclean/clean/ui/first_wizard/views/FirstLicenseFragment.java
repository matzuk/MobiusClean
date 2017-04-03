package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.LicenseFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.ui.first_wizard.FirstWizardConstants.FIRST_NAMED_ANNOTATION;


/**
 * @author e.matsyuk
 */
public class FirstLicenseFragment extends LicenseFragment {

    @Inject
    @Named(FIRST_NAMED_ANNOTATION)
    ILicensePresenter licensePresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected ILicensePresenter getPresenter() {
        return licensePresenter;
    }

}
