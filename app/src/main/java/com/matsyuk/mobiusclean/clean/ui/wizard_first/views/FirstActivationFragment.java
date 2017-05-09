package com.matsyuk.mobiusclean.clean.ui.wizard_first.views;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.ActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.ActivationFragment;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.LicensePresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.FIRST_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
public class FirstActivationFragment extends ActivationFragment {

    @Inject
    IActivationWizardPart activationWizardPart;

    @ProvidePresenter
    ActivationPresenter provideActivationPresenter() {
        return new ActivationPresenter(activationWizardPart);
    }

    @InjectPresenter
    ActivationPresenter activationPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected IActivationPresenter getPresenter() {
        return activationPresenter;
    }

}
