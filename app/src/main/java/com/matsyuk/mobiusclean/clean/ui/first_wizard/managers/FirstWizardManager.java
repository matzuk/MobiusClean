package com.matsyuk.mobiusclean.clean.ui.first_wizard.managers;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstWizardManager implements IInfoWizardPart, ILicenseWizardPart, IActivationWizardPart {

    private Router router;

    // TODO move to DI
    private FirstWizardState firstWizardState = new FirstWizardState(FirstStage.START_INFO);

    public FirstWizardManager(Router router) {
        this.router = router;
        router.navigateTo(WIZARD_INFO_START_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        if (firstWizardState.getFirstStage() == FirstStage.START_INFO) {
            firstWizardState.setFirstStage(FirstStage.LICENSE);
            router.navigateTo(WIZARD_LICENSE_SCREEN);
        } else if (firstWizardState.getFirstStage() == FirstStage.FINISH_INFO) {
            router.finishChain();
        }
    }

    @Override
    public void infoWizardBack() {
        router.finishChain();
    }

    /**
     * ILicenseWizardPart
     */

    @Override
    public void licenseWizardAccept() {
        firstWizardState.setFirstStage(FirstStage.ACTIVATION);
        router.navigateTo(WIZARD_ACTIVATION_SCREEN);
    }

    @Override
    public void licenseWizardBack() {
        firstWizardState.setFirstStage(FirstStage.START_INFO);
        router.backTo(WIZARD_INFO_START_SCREEN);
    }

    /**
     * IActivationWizardPart
     */

    @Override
    public void activationWizardCodeActivationNext() {

    }

    @Override
    public void activationWizardPersonalAccountNext() {

    }

    @Override
    public void activationWizardFreeNext() {
        firstWizardState.setFirstStage(FirstStage.FINISH_INFO);
        router.navigateTo(WIZARD_INFO_FINISH_SCREEN);
    }

    @Override
    public void activationWizardBack() {
        firstWizardState.setFirstStage(FirstStage.LICENSE);
        router.backTo(WIZARD_LICENSE_SCREEN);
    }

}
