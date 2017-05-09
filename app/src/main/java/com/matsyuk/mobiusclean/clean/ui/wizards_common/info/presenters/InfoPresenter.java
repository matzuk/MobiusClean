package com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

/**
 * @author e.matsyuk
 */
@InjectViewState
public class InfoPresenter extends MvpPresenter<IInfoView> implements IInfoPresenter {

    private IInfoWizardPart wizardPart;
    private TextType textType;

    public InfoPresenter(IInfoWizardPart wizardPart, TextType textType) {
        this.wizardPart = wizardPart;
        this.textType = textType;
    }

    @Override
    protected void onFirstViewAttach() {
        getViewState().showText(textType);
    }

    @Override
    public void clickNext() {
        wizardPart.infoWizardNext();
    }

    @Override
    public void clickBack() {
        wizardPart.infoWizardBack();
    }

}
