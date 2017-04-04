package com.matsyuk.mobiusclean.clean.dagger.wizard_first;

import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.FIRST_NAMED_ANNOTATION;

/**
 * @author e.matsyuk
 */
@Module
public class FirstNavigationModule {

    private Cicerone<Router> cicerone;

    public FirstNavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @WizardScope
    @Named(FIRST_NAMED_ANNOTATION)
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @WizardScope
    @Named(FIRST_NAMED_ANNOTATION)
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

}
