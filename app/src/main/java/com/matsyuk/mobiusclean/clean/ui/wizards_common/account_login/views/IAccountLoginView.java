package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views;

/**
 * @author e.matsyuk
 */
public interface IAccountLoginView {

    void showSuccessLogin();
    void showErrorLogin();
    void showProgress(boolean show);
    void loginEnabled(boolean enable);
}
