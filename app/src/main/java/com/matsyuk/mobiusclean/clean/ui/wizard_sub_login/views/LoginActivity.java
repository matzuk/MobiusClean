package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.managers.LoginWizardManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.IAccountLoginPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.*;
import static com.matsyuk.mobiusclean.clean.ui.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public abstract class LoginActivity extends AppCompatActivity {

    @Inject
    @Named(LOGIN_NAMED_ANNOTATION)
    NavigatorHolder navigatorHolder;

    @Inject
    @Named(LOGIN_NAMED_ANNOTATION)
    IAccountLoginPresenter accountLoginPresenter;

    @Inject
    @Named(LOGIN_NAMED_ANNOTATION)
    IInfoPresenter infoPresenter;

    @Inject
    LoginWizardManager loginWizardManager;

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.start_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            if (screenKey.equals(SUB_WIZARD_LOGIN_INFO_SCREEN)) {
                LoginInfoFragment loginInfoFragment = new LoginInfoFragment();
                loginInfoFragment.setInfoPresenter(infoPresenter);
                return loginInfoFragment;
            } else if (screenKey.equals(SUB_WIZARD_LOGIN_LOGIN_SCREEN)) {
                LoginAccountLoginFragment loginAccountLoginFragment = new LoginAccountLoginFragment();
                loginAccountLoginFragment.setAccountLoginPresenter(accountLoginPresenter);
                return loginAccountLoginFragment;
            }
            return null;
        }

        @Override
        protected void showSystemMessage(String message) {
            // no actions yet
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectActivity();
        setContentView(R.layout.ac_login);
        setTitle(getString(R.string.ac_login_wizard_title));
    }

    @Override
    protected void onResumeFragments() {
        reInjectFragments();
        super.onResumeFragments();
        loginWizardManager.startWizard();
    }

    @SuppressWarnings("RestrictedApi")
    private void reInjectFragments() {
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        if (fragmentList == null) {
            return;
        }
        for (int i = 0; i < fragmentList.size(); i++) {
            Fragment fragment = fragmentList.get(i);
            if (fragment instanceof LoginAccountLoginFragment) {
                LoginAccountLoginFragment loginAccountLoginFragment =
                        (LoginAccountLoginFragment)fragment;
                loginAccountLoginFragment.setAccountLoginPresenter(accountLoginPresenter);
            } else if (fragment instanceof LoginInfoFragment) {
                LoginInfoFragment loginInfoFragment =
                        (LoginInfoFragment)fragment;
                loginInfoFragment.setInfoPresenter(infoPresenter);
            }
        }

    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.start_container);
        if (fragment != null
                && fragment instanceof BackButtonListener
                && ((BackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    public void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    protected abstract void injectActivity();

}
