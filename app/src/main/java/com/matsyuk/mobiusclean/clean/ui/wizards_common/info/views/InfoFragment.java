package com.matsyuk.mobiusclean.clean.ui.wizards_common.info.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.info.presenters.IInfoPresenter;

/**
 * @author e.matsyuk
 */
public abstract class InfoFragment extends MvpAppCompatFragment implements IInfoView, BackButtonListener {

    private TextView infoText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_info, container, false);
        infoText = (TextView)view.findViewById(R.id.info_text);
        Button nextButton = (Button) view.findViewById(R.id.btn_next);
        nextButton.setOnClickListener(v -> getPresenter().clickNext());

        return view;
    }

    @Override
    public void showText(TextType textType) {
        if (textType == TextType.START) {
            infoText.setText(getString(R.string.fmt_info_text_start));
        } else if (textType == TextType.FINISH) {
            infoText.setText(getString(R.string.fmt_info_text_finish));
        } else if (textType == TextType.LOGIN) {
            infoText.setText(getString(R.string.fmt_info_text_login));
        }

    }

    @Override
    public boolean onBackPressed() {
        getPresenter().clickBack();
        return true;
    }

    protected abstract IInfoPresenter getPresenter();

}
