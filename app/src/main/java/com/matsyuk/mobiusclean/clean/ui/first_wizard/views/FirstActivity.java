package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.managers.FirstWizardManager;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstActivity extends AppCompatActivity {

    @Inject
    @Named(FIRST_NAMED_ANNOTATION)
    NavigatorHolder navigatorHolder;

    // TODO temp for first start
    @Inject
    FirstWizardManager firstWizardManager;

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.start_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            if (screenKey.equals(WIZARD_INFO_START_SCREEN)) {
                return new FirstInfoStartFragment();
            } else if (screenKey.equals(WIZARD_LICENSE_SCREEN)) {
                return new FirstLicenseFragment();
            } else if (screenKey.equals(WIZARD_ACTIVATION_SCREEN)) {
                return new FirstActivationFragment();
            } else if (screenKey.equals(WIZARD_INFO_FINISH_SCREEN)) {
                return new FirstInfoFinishFragment();
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
        ComponentManager.getInstance().getFirstComponent().inject(this);
        setContentView(R.layout.ac_start);
        setTitle(getString(R.string.ac_start_wizard_title));
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

    @Override
    public void onDestroy() {
        if (isFinishing()) {
            ComponentManager.getInstance().clearFirstComponent();
        }
        super.onDestroy();
    }

}
