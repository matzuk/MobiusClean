package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.ActivationFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.ui.first_wizard.FirstWizardConstants.FIRST_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
public class FirstActivationFragment extends ActivationFragment {

    @Inject
    @Named(FIRST_NAMED_ANNOTATION)
    IActivationPresenter activationPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected IActivationPresenter getPresenter() {
        return activationPresenter;
    }

}
