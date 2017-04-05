package com.matsyuk.mobiusclean.clean.ui.wizard_sub_login.views;

import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views.InfoFragment;


/**
 * @author e.matsyuk
 */
public class LoginInfoFragment extends InfoFragment {

    @Override
    protected IInfoPresenter getPresenter() {
        LoginActivity loginActivity = (LoginActivity)getActivity();
        return loginActivity.getInfoPresenter();
    }

}
