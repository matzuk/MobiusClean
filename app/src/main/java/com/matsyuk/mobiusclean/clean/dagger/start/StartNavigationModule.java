package com.matsyuk.mobiusclean.clean.dagger.start;

import com.matsyuk.mobiusclean.clean.dagger.main.MainScope;

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
public class StartNavigationModule {

    private Cicerone<Router> cicerone;

    public StartNavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @StartScope
    @Named("start_wizard")
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @StartScope
    @Named("start_wizard")
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

}
