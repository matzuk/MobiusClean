package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.presenters;

import com.matsyuk.mobiusclean.clean.business.auth.IAuthInteractor;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.views.IAccountRegistrationView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.wizard_part.IAccountRegistrationWizardPart;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author e.matsyuk
 */
public class AccountRegistrationPresenter implements IAccountRegistrationPresenter {

    private IAccountRegistrationWizardPart accountRegistrationWizardPart;
    private IAuthInteractor authInteractor;

    private IAccountRegistrationView accountRegistrationView;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AccountRegistrationPresenter(IAccountRegistrationWizardPart accountRegistrationWizardPart,
                                        IAuthInteractor authInteractor) {
        this.accountRegistrationWizardPart = accountRegistrationWizardPart;
        this.authInteractor = authInteractor;
    }

    @Override
    public void bindView(IAccountRegistrationView accountRegistrationView) {
        this.accountRegistrationView = accountRegistrationView;
    }

    @Override
    public void unbindView() {
        accountRegistrationView = null;
    }

    @Override
    public void clickRegistration(String mail, String password, String retryPassword) {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            accountRegistrationView.showErrorMail();
            return;
        }
        if (!password.equals(retryPassword)) {
            accountRegistrationView.showPasswordError();
            return;
        }
        authInteractor.registration(mail, password)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleRegistrationResult, throwable -> {});
    }

    @Override
    public void inputText() {
        if (accountRegistrationView != null) {
            accountRegistrationView.clearInputErrors();
        }
    }

    private void handleRegistrationResult(boolean success) {
        if (success) {
            accountRegistrationView.showSuccess();
            accountRegistrationWizardPart.accountRegistrationWizardSuccess();
        } else {
            accountRegistrationView.showAuthError();
        }
    }

    @Override
    public void clickBack() {
        accountRegistrationWizardPart.accountRegistrationWizardBack();
    }

}
