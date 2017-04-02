package com.matsyuk.mobiusclean.clean.dagger.main;

import com.matsyuk.mobiusclean.clean.ui.main.presenters.IMainPresenter;
import com.matsyuk.mobiusclean.clean.ui.main.presenters.MainPresenter;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Router;

/**
 * @author e.matsyuk
 */
@Module
public class MainModule {

    @MainScope
    @Provides
    public IMainPresenter provideMainPresenter(@Named("main") Router router) {
        return new MainPresenter(router);
    }

}
