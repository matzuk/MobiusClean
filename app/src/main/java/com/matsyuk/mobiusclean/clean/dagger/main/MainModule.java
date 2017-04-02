package com.matsyuk.mobiusclean.clean.dagger.main;

import com.matsyuk.mobiusclean.clean.ui.main.presenters.IMainPresenter;
import com.matsyuk.mobiusclean.clean.ui.main.presenters.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author e.matsyuk
 */
@Module
public class MainModule {

    @MainScope
    @Provides
    public IMainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

}
