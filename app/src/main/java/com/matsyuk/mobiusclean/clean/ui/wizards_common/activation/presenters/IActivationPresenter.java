package com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views.IActivationView;

/**
 * @author e.matsyuk
 */
public interface IActivationPresenter {

    void bindView(IActivationView activationView);
    void unbindView();

    void clickPersonalAccount();
    void clickFreeVersion();
    void clickBack();

}
