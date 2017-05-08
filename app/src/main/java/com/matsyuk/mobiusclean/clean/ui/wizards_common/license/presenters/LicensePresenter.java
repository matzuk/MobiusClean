package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters;

import com.arellomobile.mvp.MvpPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.ILicenseView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

/**
 * @author e.matsyuk
 */
public class LicensePresenter extends MvpPresenter<ILicenseView> implements ILicensePresenter {

    private ILicenseWizardPart licenseWizardPart;

    public LicensePresenter(ILicenseWizardPart licenseWizardPart) {
        this.licenseWizardPart = licenseWizardPart;
    }

    @Override
    public void acceptLicense() {
        licenseWizardPart.licenseWizardAccept();
    }

    @Override
    public void clickBack() {
        licenseWizardPart.licenseWizardBack();
    }

}
