package com.matsyuk.mobiusclean.clean.dagger.app;

import com.matsyuk.mobiusclean.clean.dagger.main.MainComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author e.matsyuk
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    MainComponent.Builder mainComponentBuilder();
}
