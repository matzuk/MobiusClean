package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.ILicenseView;

/**
 * @author e.matsyuk
 */
public interface ILicensePresenter {

    void bindView(ILicenseView licenseView);
    void unbindView();

    void acceptLicense();
    void onBackClick();

}
