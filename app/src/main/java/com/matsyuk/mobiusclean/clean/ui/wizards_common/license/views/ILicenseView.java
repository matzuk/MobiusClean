package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * @author e.matsyuk
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface ILicenseView extends MvpView {

    void showProgress();
    void hideProgress();

}
