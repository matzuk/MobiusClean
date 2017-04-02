package com.matsyuk.mobiusclean.clean.ui.main.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.dagger.ComponentManager;
import com.matsyuk.mobiusclean.clean.ui.main.presenters.IMainPresenter;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements IMainView {

    @Inject
    IMainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getMainComponent().inject(this);
        // view
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainPresenter.bindView(this);
    }

    @Override
    public void onDestroy() {
        mainPresenter.unbindView();
        super.onDestroy();
    }

}
