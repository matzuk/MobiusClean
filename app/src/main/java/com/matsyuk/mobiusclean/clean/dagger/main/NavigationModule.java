package com.matsyuk.mobiusclean.clean.dagger.main;

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
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @MainScope
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

}
