package com.matsyuk.mobiusclean.clean.ui.first_wizard.managers;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.first_wizard.FirstWizardConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstWizardManager implements IInfoWizardPart, ILicenseWizardPart, IActivationWizardPart {

    private Router router;

    // TODO move to DI
    private FirstWizardState firstWizardState = new FirstWizardState(FirstWizardStage.START_INFO);

    public FirstWizardManager(Router router) {
        this.router = router;
        router.navigateTo(WIZARD_INFO_START_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        if (firstWizardState.getFirstWizardStage() == FirstWizardStage.START_INFO) {
            firstWizardState.setFirstWizardStage(FirstWizardStage.LICENSE);
            router.navigateTo(WIZARD_LICENSE_SCREEN);
        } else if (firstWizardState.getFirstWizardStage() == FirstWizardStage.FINISH_INFO) {
            router.exit();
        }
    }

    @Override
    public void infoWizardBack() {
        router.exit();
    }

    /**
     * ILicenseWizardPart
     */

    @Override
    public void licenseWizardAccept() {
        firstWizardState.setFirstWizardStage(FirstWizardStage.ACTIVATION);
        router.navigateTo(WIZARD_ACTIVATION_SCREEN);
    }

    @Override
    public void licenseWizardBack() {
        firstWizardState.setFirstWizardStage(FirstWizardStage.START_INFO);
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

    }

    @Override
    public void activationWizardBack() {
        firstWizardState.setFirstWizardStage(FirstWizardStage.LICENSE);
        router.backTo(WIZARD_LICENSE_SCREEN);
    }

}
