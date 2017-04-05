package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.views.IAccountRegistrationView;

/**
 * @author e.matsyuk
 */
public interface IAccountRegistrationPresenter {

    void bindView(IAccountRegistrationView accountRegistrationView);
    void unbindView();

    void clickRegistration(String mail, String password, String retryPassword);
    void inputText();
    void clickBack();

}
