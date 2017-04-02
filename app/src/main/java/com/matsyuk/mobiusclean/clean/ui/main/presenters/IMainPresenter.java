package com.matsyuk.mobiusclean.clean.ui.main.presenters;

import com.matsyuk.mobiusclean.clean.ui.main.views.IMainView;

/**
 * @author e.matsyuk
 */
public interface IMainPresenter {

    void bindView(IMainView mainView);
    void unbindView();

    void clickStartWizard();
    void clickAppLockWizard();

}
