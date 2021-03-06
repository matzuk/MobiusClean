package com.matsyuk.mobiusclean.clean.dagger.main;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * @author e.matsyuk
 */
@Module
public class NavigationModule {

    private Cicerone<Router> cicerone;

    public NavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @MainScope
    @Named("main")
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @MainScope
    @Named("main")
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

}
