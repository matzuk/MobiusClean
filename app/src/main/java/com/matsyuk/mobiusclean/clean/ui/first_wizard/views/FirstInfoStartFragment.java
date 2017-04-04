package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.InfoFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.FIRST_INFO_START_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
public class FirstInfoStartFragment extends InfoFragment {

    @Inject
    @Named(FIRST_INFO_START_NAMED_ANNOTATION)
    IInfoPresenter infoPresenter;

    @Override
    public void onResume() {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onResume();
    }

    @Override
    protected IInfoPresenter getPresenter() {
        return infoPresenter;
    }

}
