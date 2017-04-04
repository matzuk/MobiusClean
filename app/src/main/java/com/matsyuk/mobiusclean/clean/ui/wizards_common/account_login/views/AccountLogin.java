package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_login.presenters.IAccountLoginPresenter;

/**
 * @author e.matsyuk
 */
public abstract class AccountLogin extends Fragment implements IAccountLoginView, BackButtonListener {

    private Button loginButton;
    private EditText loginInput;
    private EditText passwordInput;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_account_login, container, false);

        progressBar = (ProgressBar)view.findViewById(R.id.progress);

        loginInput = (EditText)view.findViewById(R.id.et_mail);
        passwordInput = (EditText)view.findViewById(R.id.et_password);

        loginButton = (Button)view.findViewById(R.id.btn_login);
        loginButton.setOnClickListener(v -> getPresenter().clickLogin(loginInput.getText().toString(), passwordInput.getText().toString()));

        Button forgotButton = (Button)view.findViewById(R.id.btn_forgot);
        forgotButton.setOnClickListener(v -> getPresenter().clickForgotPassword());

        Button newAccountButton = (Button)view.findViewById(R.id.btn_reg);
        newAccountButton.setOnClickListener(v -> getPresenter().clickNewAccount());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().bindView(this);
        getPresenter().inputData(
                RxTextView.textChanges(loginInput).map(CharSequence::toString),
                RxTextView.textChanges(passwordInput).map(CharSequence::toString)
        );
    }

    @Override
    public boolean onBackPressed() {
        getPresenter().clickBack();
        return true;
    }

    @Override
    public void onDestroy() {
        getPresenter().unbindView();
        super.onDestroy();
    }

    @Override
    public void showSuccessLogin() {
        Toast.makeText(getContext(), getString(R.string.fmt_activation_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorLogin() {
        Toast.makeText(getContext(), getString(R.string.fmt_activation_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void loginEnabled(boolean enable) {
        loginButton.setEnabled(enable);
    }

    protected abstract IAccountLoginPresenter getPresenter();

}
