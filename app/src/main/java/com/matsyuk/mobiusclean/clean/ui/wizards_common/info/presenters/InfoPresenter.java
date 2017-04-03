package com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.IInfoView;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

/**
 * Created by Евгений on 02.04.2017.
 */

public class InfoPresenter implements IInfoPresenter {

    private IInfoWizardPart wizardPart;
    private TextType textType;

    // TODO move to moxy
    private IInfoView infoView;

    public InfoPresenter(IInfoWizardPart wizardPart, TextType textType) {
        this.wizardPart = wizardPart;
        this.textType = textType;
    }

    @Override
    public void bindView(IInfoView infoView) {
        this.infoView = infoView;
        infoView.showText(textType);
    }

    @Override
    public void unbindView() {
        infoView = null;
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
