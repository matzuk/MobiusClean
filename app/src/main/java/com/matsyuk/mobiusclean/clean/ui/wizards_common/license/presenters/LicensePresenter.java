package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.matsyuk.mobiusclean.clean.business.first_wizard.IFirstWizardInteractor;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views.ILicenseView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.wizard_part.ILicenseWizardPart;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author e.matsyuk
 */
@InjectViewState
public class LicensePresenter extends MvpPresenter<ILicenseView> implements ILicensePresenter {

    private ILicenseWizardPart licenseWizardPart;
    private IFirstWizardInteractor firstWizardInteractor;

    private Disposable disposable;

    public LicensePresenter(ILicenseWizardPart licenseWizardPart, IFirstWizardInteractor firstWizardInteractor) {
        this.licenseWizardPart = licenseWizardPart;
        this.firstWizardInteractor = firstWizardInteractor;
    }

    @Override
    public void acceptLicense() {
        if (disposable != null) {
            return;
        }
        disposable = firstWizardInteractor.acceptLicense()
                .doOnSubscribe(disposable -> getViewState().showProgress())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aBoolean -> {
                    getViewState().hideProgress();
                    licenseWizardPart.licenseWizardAccept();
                }, throwable -> {});
    }

    @Override
    public void clickBack() {
        licenseWizardPart.licenseWizardBack();
    }

    @Override
    public void onDestroy() {
        if (disposable != null) {
            disposable.dispose();
        }
        super.onDestroy();
    }

}
