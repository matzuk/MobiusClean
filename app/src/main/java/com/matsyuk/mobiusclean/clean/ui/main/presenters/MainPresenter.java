package com.matsyuk.mobiusclean.clean.ui.main.presenters;

import android.support.annotation.NonNull;

import com.matsyuk.mobiusclean.clean.ui.main.views.IMainView;

/**
 * @author e.matsyuk
 */
public class MainPresenter implements IMainPresenter {

    // TODO move to moxy
    @NonNull
    IMainView mainView;

    @Override
    public void bindView(IMainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void unbindView() {
        mainView = null;
    }

    @Override
    public void clickStartWizard() {

    }

    @Override
    public void clickAppLockWizard() {

    }

}
