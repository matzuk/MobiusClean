package com.matsyuk.mobiusclean.clean.dagger.app;

import com.matsyuk.mobiusclean.clean.business.auth.AuthInteractorFake;
import com.matsyuk.mobiusclean.clean.business.auth.IAuthInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class AppModule {

    @Singleton
    @Provides
    public IAuthInteractor provideAuthInteractor() {
        return new AuthInteractorFake();
    }

}
