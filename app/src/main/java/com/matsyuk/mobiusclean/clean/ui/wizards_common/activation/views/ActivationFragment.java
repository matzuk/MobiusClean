package com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.activation.presenters.IActivationPresenter;

/**
 * @author e.matsyuk
 */
public abstract class ActivationFragment extends MvpAppCompatFragment implements IActivationView, BackButtonListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_activation, container, false);
        //
        Button personalAccountButton = (Button)view.findViewById(R.id.btn_personal_account);
        personalAccountButton.setOnClickListener(v -> getPresenter().clickPersonalAccount());
        //
        Button freeButton = (Button)view.findViewById(R.id.btn_free);
        freeButton.setOnClickListener(v -> getPresenter().clickFreeVersion());
        //
        return view;
    }

    @Override
    public boolean onBackPressed() {
        getPresenter().clickBack();
        return true;
    }

    protected abstract IActivationPresenter getPresenter();

}
