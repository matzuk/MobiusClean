package com.matsyuk.mobiusclean.clean.dagger.main;

import com.matsyuk.mobiusclean.clean.ui.main.views.MainActivity;

import dagger.Subcomponent;

/**
 * @author e.matsyuk
 */
@MainScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    @Subcomponent.Builder
    interface Builder {
        MainComponent.Builder mainModule(MainModule mainModule);
        MainComponent build();
    }

    void inject(MainActivity mainActivity);

}
