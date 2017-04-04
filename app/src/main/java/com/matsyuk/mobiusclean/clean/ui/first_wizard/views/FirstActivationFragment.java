package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.ActivationFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.FIRST_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
public class FirstActivationFragment extends ActivationFragment {

    @Inject
    @Named(FIRST_NAMED_ANNOTATION)
    IActivationPresenter activationPresenter;

    @Override
    public void onResume() {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onResume();
    }

    @Override
    protected IActivationPresenter getPresenter() {
        return activationPresenter;
    }

}
