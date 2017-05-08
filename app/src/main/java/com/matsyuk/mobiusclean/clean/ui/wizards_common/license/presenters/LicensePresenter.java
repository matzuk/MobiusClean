package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters;

import com.arellomobile.mvp.MvpPresenter;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.ILicenseView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author e.matsyuk
 */
public class LicensePresenter extends MvpPresenter<ILicenseView> implements ILicensePresenter {

    private ILicenseWizardPart licenseWizardPart;
    private IFirstWizardInteractor firstWizardInteractor;

    public LicensePresenter(ILicenseWizardPart licenseWizardPart, IFirstWizardInteractor firstWizardInteractor) {
        this.licenseWizardPart = licenseWizardPart;
        this.firstWizardInteractor = firstWizardInteractor;
    }

    @Override
    public void acceptLicense() {
        getViewState().showProgress();
        firstWizardInteractor.acceptLicense()
                .doOnSubscribe(disposable -> getViewState().showProgress())
                .doOnSuccess(disposable -> getViewState().hideProgress())
                .doAfterSuccess(disposable -> licenseWizardPart.licenseWizardAccept())
                .subscribe(aBoolean -> {}, throwable -> {});
    }

    @Override
    public void clickBack() {
        licenseWizardPart.licenseWizardBack();
    }

}
