package com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.IActivationView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;

/**
 * @author e.matsyuk
 */
public class ActivationPresenter implements IActivationPresenter {

    private IActivationWizardPart activationWizardPart;
    private IActivationView activationView;

    public ActivationPresenter(IActivationWizardPart activationWizardPart) {
        this.activationWizardPart = activationWizardPart;
    }

    @Override
    public void bindView(IActivationView activationView) {
        this.activationView = activationView;
    }

    @Override
    public void unbindView() {
        activationView = null;
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
