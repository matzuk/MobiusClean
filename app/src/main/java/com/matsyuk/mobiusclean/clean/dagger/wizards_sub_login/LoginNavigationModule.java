package com.matsyuk.mobiusclean.clean.dagger.wizards_sub_login;

import com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardConstants.*;

/**
 * @author e.matsyuk
 */
@Module
public class LoginNavigationModule {

    private Cicerone<Router> cicerone;

    public LoginNavigationModule() {
        cicerone = Cicerone.create();
    }

    @Provides
    @WizardScope
    @Named(LOGIN_NAMED_ANNOTATION)
    Router provideRouter() {
        return cicerone.getRouter();
    }

    @Provides
    @WizardScope
    @Named(LOGIN_NAMED_ANNOTATION)
    NavigatorHolder provideNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

}
