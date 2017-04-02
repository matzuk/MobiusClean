package com.matsyuk.mobiusclean.clean.ui.main.presenters;

import android.support.annotation.NonNull;

import com.matsyuk.mobiusclean.clean.ui.main.views.IMainView;

import ru.terrakok.cicerone.Router;

import static com.matsyuk.mobiusclean.clean.utils.ScreenNames.*;

/**
 * @author e.matsyuk
 */
public class MainPresenter implements IMainPresenter {

    private Router router;

    // TODO move to moxy
    IMainView mainView;

    public MainPresenter(Router router) {
        this.router = router;
    }

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
        router.navigateTo(START_WIZARD);
    }

    @Override
    public void clickAppLockWizard() {
        router.navigateTo(APP_LOCK_WIZARD);
    }

}
