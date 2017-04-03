package com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;

/**
 * @author e.matsyuk
 */
public interface IInfoPresenter {

    void bindView(IInfoView infoView);
    void unbindView();

    void clickNext();
    void clickBack();

}
