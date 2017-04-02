package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;

/**
 * @author e.matsyuk
 */
public abstract class LicenseFragment extends Fragment implements ILicenseView, BackButtonListener {

    private Button nextButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_license, container, false);

        nextButton = (Button)view.findViewById(R.id.btn_next);
        nextButton.setOnClickListener(v -> getPresenter().acceptLicense());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().bindView(this);
    }

    @Override
    public boolean onBackPressed() {
        getPresenter().onBackClick();
        return true;
    }

    @Override
    public void onDestroy() {
        getPresenter().unbindView();
        super.onDestroy();
    }

    protected abstract ILicensePresenter getPresenter();

}
