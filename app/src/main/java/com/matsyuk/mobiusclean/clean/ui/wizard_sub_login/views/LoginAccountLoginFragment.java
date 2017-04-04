package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.IAccountLoginPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views.AccountLoginFragment;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.LOGIN_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
public class LoginAccountLoginFragment extends AccountLoginFragment {

    @Inject
    @Named(LOGIN_NAMED_ANNOTATION)
    IAccountLoginPresenter accountLoginPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ComponentManager.getInstance().getFirstComponent().inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected IAccountLoginPresenter getPresenter() {
        return accountLoginPresenter;
    }

}