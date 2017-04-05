package com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router;

import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.smart_router.ILoginWizardResult;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.wizard_part.IActivationWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.ui.wizard_first.smart_router.FirstWizardStep.*;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstWizardSmartRouter implements IInfoWizardPart, ILicenseWizardPart,
        IActivationWizardPart, ILoginWizardResult {

    private final Router router;
    private FirstWizardStep currentFirstWizardStep;

    public FirstWizardSmartRouter(Router router, FirstWizardStep firstWizardState) {
        this.router = router;
        this.currentFirstWizardStep = firstWizardState;
    }

    public void startWizard() {
        if (currentFirstWizardStep != NONE) {
            return;
        }
        currentFirstWizardStep = START_INFO;
        router.navigateTo(WIZARD_FIRST_INFO_START_SCREEN);
    }

    /**
     * IInfoWizardPart
     */

    @Override
    public void infoWizardNext() {
        if (currentFirstWizardStep == START_INFO) {
            currentFirstWizardStep = LICENSE;
            router.navigateTo(WIZARD_FIRST_LICENSE_SCREEN);
        } else if (currentFirstWizardStep == FINISH_INFO) {
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
        currentFirstWizardStep = ACTIVATION;
        router.navigateTo(WIZARD_FIRST_ACTIVATION_SCREEN);
    }

    @Override
    public void licenseWizardBack() {
        currentFirstWizardStep = FirstWizardStep.START_INFO;
        router.backTo(WIZARD_FIRST_INFO_START_SCREEN);
    }

    /**
     * IActivationWizardPart
     */

    @Override
    public void activationWizardPersonalAccountNext() {
        router.navigateTo(WIZARD_FIRST_ACCOUNT_SUB_WIZARD);
    }

    @Override
    public void activationWizardFreeNext() {
        currentFirstWizardStep = FINISH_INFO;
        router.navigateTo(WIZARD_FIRST_INFO_FINISH_SCREEN);
    }

    @Override
    public void activationWizardBack() {
        currentFirstWizardStep = FirstWizardStep.LICENSE;
        router.backTo(WIZARD_FIRST_LICENSE_SCREEN);
    }

    /**
     * ILoginWizardResult
     */

    @Override
    public void onSuccess() {
        currentFirstWizardStep = FINISH_INFO;
        router.navigateTo(WIZARD_FIRST_INFO_FINISH_SCREEN);
    }

    @Override
    public void onBack() {
        currentFirstWizardStep = ACTIVATION;
        router.backTo(WIZARD_FIRST_ACTIVATION_SCREEN);
    }
}
