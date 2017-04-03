package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters;

import com.matsyuk.mobiusclean.clean.business.auth.IAuthInteractor;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views.IAccountLoginView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.wizard_part.IAccountLoginWizardPart;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author e.matsyuk
 */
public class AccountLoginPresenter implements IAccountLoginPresenter {

    private IAccountLoginWizardPart accountLoginWizardPart;
    private IAuthInteractor authInteractor;

    private IAccountLoginView accountLoginView;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AccountLoginPresenter(IAccountLoginWizardPart accountLoginWizardPart,
                                 IAuthInteractor authInteractor) {
        this.accountLoginWizardPart = accountLoginWizardPart;
        this.authInteractor = authInteractor;
    }

    @Override
    public void bindView(IAccountLoginView accountLoginView) {
        this.accountLoginView = accountLoginView;
    }

    @Override
    public void unbindView() {
        compositeDisposable.clear();
        accountLoginView = null;
    }

    @Override
    public void clickLogin(String login, String password) {
        accountLoginView.showProgress(true);
        Disposable disposable = authInteractor.login(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, throwable -> {});
        compositeDisposable.add(disposable);
    }

    private void handleResult(boolean success) {
        accountLoginView.showProgress(false);
        if (success) {
            accountLoginView.showSuccessLogin();
            accountLoginWizardPart.accountLoginWizardSuccess();
        } else {
            accountLoginView.showErrorLogin();
        }
    }

    @Override
    public void clickForgotPassword() {
        accountLoginWizardPart.accountLoginWizardForgot();
    }

    @Override
    public void clickNewAccount() {
        accountLoginWizardPart.accountLoginWizardNewAccount();
    }

    @Override
    public void clickBack() {
        accountLoginWizardPart.accountLoginWizardBack();
    }

    @Override
    public void inputData(Observable<String> loginObservable, Observable<String> passwordObservable) {
        Disposable disposable = Observable.combineLatest(loginObservable, passwordObservable,
                (login, password) -> !login.isEmpty() && !password.isEmpty())
                .subscribe();
        compositeDisposable.add(disposable);
    }

}
