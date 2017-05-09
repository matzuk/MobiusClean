package com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.IActivationView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;

/**
 * @author e.matsyuk
 */
@InjectViewState
public class ActivationPresenter extends MvpPresenter<IActivationView> implements IActivationPresenter {

    private IActivationWizardPart activationWizardPart;

    public ActivationPresenter(IActivationWizardPart activationWizardPart) {
        this.activationWizardPart = activationWizardPart;
    }

    @Override
    public void clickPersonalAccount() {
        activationWizardPart.activationWizardPersonalAccountNext();
    }

    @Override
    public void clickFreeVersion() {
        activationWizardPart.activationWizardFreeNext();
    }

    @Override
    public void clickBack() {
        activationWizardPart.activationWizardBack();
    }

}
