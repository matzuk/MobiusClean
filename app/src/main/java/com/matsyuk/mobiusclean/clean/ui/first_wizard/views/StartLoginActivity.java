package com.matsyuk.mobiusclean.clean.ui.first_wizard.views;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views.LoginActivity;

/**
 * @author e.matsyuk
 */
public class StartLoginActivity extends LoginActivity {

    @Override
    protected void injectActivity() {
        ComponentManager.getInstance().getFirstComponent().inject(this);
    }

}
