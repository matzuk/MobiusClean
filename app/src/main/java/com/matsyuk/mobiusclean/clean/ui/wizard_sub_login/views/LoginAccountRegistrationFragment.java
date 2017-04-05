package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.presenters.IAccountRegistrationPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.views.AccountRegistrationFragment;

/**
 * @author e.matsyuk
 */
public class LoginAccountRegistrationFragment extends AccountRegistrationFragment {

    @Override
    protected IAccountRegistrationPresenter getPresenter() {
        LoginActivity loginActivity = (LoginActivity)getActivity();
        return loginActivity.getAccountRegistrationPresenter();
    }

}
