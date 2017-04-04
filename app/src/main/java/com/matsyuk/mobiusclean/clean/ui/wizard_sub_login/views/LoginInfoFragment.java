package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.InfoFragment;


/**
 * @author e.matsyuk
 */
public class LoginInfoFragment extends InfoFragment {

    private IInfoPresenter infoPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setInfoPresenter(IInfoPresenter infoPresenter) {
        this.infoPresenter = infoPresenter;
    }

    @Override
    protected IInfoPresenter getPresenter() {
        return infoPresenter;
    }

}
