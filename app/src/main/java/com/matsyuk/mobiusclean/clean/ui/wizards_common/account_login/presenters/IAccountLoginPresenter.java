package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views.IAccountLoginView;

import io.reactivex.Observable;

/**
 * @author e.matsyuk
 */
public interface IAccountLoginPresenter {

    void bindView(IAccountLoginView accountLoginView);
    void unbindView();

    void clickLogin(String login, String password);
    void clickNewAccount();
    void clickBack();

    void inputData(Observable<String> loginObservable,Observable<String> passwordObservable);

}
