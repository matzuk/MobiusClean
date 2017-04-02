package com.matsyuk.mobiusclean.clean.ui.start_wizard.managers;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.utils.ScreenNames.*;

/**
 * @author e.matsyuk
 */
public class StartWizardManager implements IInfoWizardPart, ILicenseWizardPart, IActivationWizardPart {

    private Router router;

    // TODO move to DI
    private StartState startState = new StartState(StartStage.START_INFO);

    public StartWizardManager(Router router) {
        this.router = router;
        router.navigateTo(WIZARD_INFO_START_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        if (startState.getStartStage() == StartStage.START_INFO) {
            startState.setStartStage(StartStage.LICENSE);
            router.navigateTo(WIZARD_LICENSE_SCREEN);
        } else if (startState.getStartStage() == StartStage.FINISH_INFO) {
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

    }

    @Override
    public void licenseWizardBack() {
        startState.setStartStage(StartStage.START_INFO);
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

    }

}
