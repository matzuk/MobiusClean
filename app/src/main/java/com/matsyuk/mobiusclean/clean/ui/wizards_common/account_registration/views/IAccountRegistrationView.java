package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.views;

/**
 * @author e.matsyuk
 */
public interface IAccountRegistrationView {

    void showProgress(boolean show);
    void showErrorMail();
    void showPasswordError();
    void showAuthError();
    void showSuccess();
    void clearInputErrors();

}
