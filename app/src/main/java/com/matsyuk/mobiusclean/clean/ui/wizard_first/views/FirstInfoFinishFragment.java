package com.matsyuk.mobiusclean.clean.ui.wizard_first.views;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.InfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.InfoFragment;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.TextType;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.wizard_part.IInfoWizardPart;

import javax.inject.Inject;
import javax.inject.Named;

import static com.matsyuk.mobiusclean.clean.dagger.wizards_common.WizardDaggerConstants.*;

/**
 * @author e.matsyuk
 */
public class FirstInfoFinishFragment extends InfoFragment {

    @Inject
    @Named(FIRST_INFO_FINISH_NAMED_ANNOTATION)
    IInfoWizardPart infoWizardPart;

    @ProvidePresenter
    InfoPresenter provideInfoPresenter() {
        return new InfoPresenter(infoWizardPart, TextType.FINISH);
    }

    @InjectPresenter
    InfoPresenter infoPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComponentManager.getInstance().getFirstComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected IInfoPresenter getPresenter() {
        return infoPresenter;
    }

}
