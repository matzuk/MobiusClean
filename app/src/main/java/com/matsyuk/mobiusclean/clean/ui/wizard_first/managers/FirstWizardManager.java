package com.matsyuk.mobiusclean.clean.ui.wizard_first.managers;

import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers.ILoginWizardResult;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstWizardManager implements IInfoWizardPart, ILicenseWizardPart,
        IActivationWizardPart, ILoginWizardResult {

    private final Router router;
    private final FirstWizardState firstWizardState;

    public FirstWizardManager(Router router, FirstWizardState firstWizardState) {
        this.router = router;
        this.firstWizardState = firstWizardState;
    }

    public void startWizard() {
        if (firstWizardState.getFirstStage() != FirstStage.NONE) {
            return;
        }
        firstWizardState.setFirstStage(FirstStage.START_INFO);
        router.navigateTo(WIZARD_FIRST_INFO_START_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        if (firstWizardState.getFirstStage() == FirstStage.START_INFO) {
            firstWizardState.setFirstStage(FirstStage.LICENSE);
            router.navigateTo(WIZARD_FIRST_LICENSE_SCREEN);
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
        router.navigateTo(WIZARD_FIRST_ACTIVATION_SCREEN);
    }

    @Override
    public void licenseWizardBack() {
        firstWizardState.setFirstStage(FirstStage.START_INFO);
        router.backTo(WIZARD_FIRST_INFO_START_SCREEN);
    }

    /**
     * IActivationWizardPart
     */

    @Override
    public void activationWizardCodeActivationNext() {

    }

    @Override
    public void activationWizardPersonalAccountNext() {
        router.navigateTo(WIZARD_FIRST_ACCOUNT_SUB_WIZARD);
    }

    @Override
    public void activationWizardFreeNext() {
        firstWizardState.setFirstStage(FirstStage.FINISH_INFO);
        router.navigateTo(WIZARD_FIRST_INFO_FINISH_SCREEN);
    }

    @Override
    public void activationWizardBack() {
        firstWizardState.setFirstStage(FirstStage.LICENSE);
        router.backTo(WIZARD_FIRST_LICENSE_SCREEN);
    }

    /**
     * ILoginWizardResult
     */

    @Override
    public void onSuccess() {
        firstWizardState.setFirstStage(FirstStage.FINISH_INFO);
        router.navigateTo(WIZARD_FIRST_INFO_FINISH_SCREEN);
    }

    @Override
    public void onBack() {
        firstWizardState.setFirstStage(FirstStage.ACTIVATION);
        router.backTo(WIZARD_FIRST_ACTIVATION_SCREEN);
    }
}
