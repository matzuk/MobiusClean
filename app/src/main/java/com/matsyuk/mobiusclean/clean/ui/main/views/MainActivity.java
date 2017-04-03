package com.matsyuk.mobiusclean.clean.ui.main.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.app_lock.views.AppLockActivity;
import com.matsyuk.mobiusclean.clean.ui.main.presenters.IMainPresenter;
import com.matsyuk.mobiusclean.clean.ui.first_wizard.views.FirstActivity;

import javax.inject.Inject;
import javax.inject.Named;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Forward;

import static com.matsyuk.mobiusclean.clean.utils.ScreenNames.*;

public class MainActivity extends AppCompatActivity implements IMainView {

    @Inject
    IMainPresenter mainPresenter;
    @Inject
    @Named("main")
    NavigatorHolder navigatorHolder;

    private Navigator navigator = command -> {
        if (command instanceof Forward) {
            Forward forward = (Forward) command;
            // create intent
            Intent activityIntent = null;
            if (forward.getScreenKey().equals(START_WIZARD)) {
                activityIntent = new Intent(MainActivity.this, FirstActivity.class);
            } else if (forward.getScreenKey().equals(APP_LOCK_WIZARD)) {
                activityIntent = new Intent(MainActivity.this, AppLockActivity.class);
            }
            // Start activity
            if (activityIntent != null) {
                MainActivity.this.startActivity(activityIntent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getMainComponent().inject(this);
        // view
        setContentView(R.layout.ac_main);
        Button startWizardButton = (Button)findViewById(R.id.btn_start);
        startWizardButton.setOnClickListener(v -> mainPresenter.clickStartWizard());
        Button appLockWizardButton = (Button)findViewById(R.id.btn_app_lock);
        appLockWizardButton.setOnClickListener(v -> mainPresenter.clickAppLockWizard());
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.bindView(this);
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    public void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mainPresenter.unbindView();
        super.onDestroy();
    }

}
