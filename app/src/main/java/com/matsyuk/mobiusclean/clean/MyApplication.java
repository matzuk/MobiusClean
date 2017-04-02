package com.matsyuk.mobiusclean.clean;

import android.app.Application;

import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;

/**
 * @author e.matsyuk
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ComponentManager.getInstance().initAppComponent();
    }

}
