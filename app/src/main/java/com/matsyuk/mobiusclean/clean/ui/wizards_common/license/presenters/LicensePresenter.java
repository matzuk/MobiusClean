package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.ILicenseView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

/**
 * @author e.matsyuk
 */
public class LicensePresenter implements ILicensePresenter {

    private ILicenseWizardPart licenseWizardPart;

    // TODO move to moxy
    private ILicenseView licenseView;

    public LicensePresenter(ILicenseWizardPart licenseWizardPart) {
        this.licenseWizardPart = licenseWizardPart;
    }

    @Override
    public void bindView(ILicenseView licenseView) {
        this.licenseView = licenseView;
    }

    @Override
    public void unbindView() {
        licenseView = null;
    }

    @Override
    public void acceptLicense() {
        licenseWizardPart.licenseWizardAccept();
    }

    @Override
    public void onBackClick() {
        licenseWizardPart.licenseWizardBack();
    }

}
