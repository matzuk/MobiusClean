package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.IAccountLoginPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views.AccountLoginFragment;

/**
 * @author e.matsyuk
 */
public class LoginAccountLoginFragment extends AccountLoginFragment {

    @Override
    protected IAccountLoginPresenter getPresenter() {
        LoginActivity loginActivity = (LoginActivity)getActivity();
        return loginActivity.getAccountLoginPresenter();
    }

}