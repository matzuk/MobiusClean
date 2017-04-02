package com.matsyuk.mobiusclean.clean.dagger;

import com.matsyuk.mobiusclean.clean.dagger.app.AppComponent;
import com.matsyuk.mobiusclean.clean.dagger.app.DaggerAppComponent;
import com.matsyuk.mobiusclean.clean.dagger.main.MainComponent;
import com.matsyuk.mobiusclean.clean.dagger.main.MainModule;
import com.matsyuk.mobiusclean.clean.dagger.start.StartComponent;

/**
 * @author e.matsyuk
 */
public class ComponentManager {

    private static volatile ComponentManager instance;

    private AppComponent appComponent;
    private MainComponent mainComponent;
    private StartComponent startComponent;

    public static ComponentManager getInstance() {
        if (instance == null) {
            synchronized (ComponentManager.class) {
                if (instance == null) {
                    instance = new ComponentManager();
                }
            }
        }
        return instance;
    }

    private ComponentManager() {}

    public void initAppComponent() {
        appComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public MainComponent getMainComponent() {
        if (mainComponent == null) {
            mainComponent = getAppComponent()
                    .mainComponentBuilder()
                    .build();
        }
        return mainComponent;
    }

    public StartComponent getStartComponent() {
        if (startComponent == null) {
            startComponent = getMainComponent()
                    .startComponentBuilder()
                    .build();
        }
        return startComponent;
    }

    public void clearStartComponent() {
        startComponent = null;
    }

}
