package com.matsyuk.mobiusclean.clean.ui.wizards_common.license.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.license.presenters.ILicensePresenter;

/**
 * @author e.matsyuk
 */
public abstract class LicenseFragment extends MvpAppCompatFragment implements ILicenseView, BackButtonListener {

    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_license, container, false);

        Button nextButton = (Button) view.findViewById(R.id.btn_next);
        nextButton.setOnClickListener(v -> getPresenter().acceptLicense());
        progressBar = (ProgressBar) view.findViewById(R.id.progress);

        return view;
    }

    @Override
    public boolean onBackPressed() {
        getPresenter().clickBack();
        return true;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    protected abstract ILicensePresenter getPresenter();

}
