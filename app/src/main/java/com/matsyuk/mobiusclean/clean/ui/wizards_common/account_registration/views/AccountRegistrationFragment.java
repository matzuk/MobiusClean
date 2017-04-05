package com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.views;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.matsyuk.mobiusclean.R;
import com.matsyuk.mobiusclean.clean.ui.common.BackButtonListener;
import com.matsyuk.mobiusclean.clean.ui.wizards_common.account_registration.presenters.IAccountRegistrationPresenter;

/**
 * @author e.matsyuk
 */
public abstract class AccountRegistrationFragment extends Fragment implements IAccountRegistrationView, BackButtonListener {

    private EditText mailInput;
    private EditText passwordInput;
    private EditText retryPasswordInput;
    private ProgressBar progressBar;
    private Button registrationButton;

    private TextWatcher commonTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            getPresenter().inputText();
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fmt_account_registration, container, false);

        progressBar = (ProgressBar)view.findViewById(R.id.progress);

        mailInput = (EditText)view.findViewById(R.id.et_mail);
        mailInput.addTextChangedListener(commonTextWatcher);
        passwordInput = (EditText)view.findViewById(R.id.et_password);
        passwordInput.addTextChangedListener(commonTextWatcher);
        retryPasswordInput = (EditText)view.findViewById(R.id.et_password_retry);
        retryPasswordInput.addTextChangedListener(commonTextWatcher);

        registrationButton = (Button)view.findViewById(R.id.btn_registration);
        registrationButton.setOnClickListener(v -> getPresenter().clickRegistration(
                mailInput.getText().toString(),
                passwordInput.getText().toString(),
                retryPasswordInput.getText().toString()
        ));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().bindView(this);
    }

    @Override
    public boolean onBackPressed() {
        getPresenter().clickBack();
        return true;
    }

    @Override
    public void onDestroyView() {
        getPresenter().unbindView();
        super.onDestroyView();
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorMail() {
        mailInput.setError(getString(R.string.fmt_account_registration_et_mail_error));
    }

    @Override
    public void showPasswordError() {
        passwordInput.setError(getString(R.string.fmt_account_registration_et_password_error));
    }

    @Override
    public void showAuthError() {
        Toast.makeText(getContext(), getString(R.string.fmt_account_registration_auth_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(getContext(), getString(R.string.fmt_account_registration_auth_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearInputErrors() {
        mailInput.setError(null);
        passwordInput.setError(null);
        retryPasswordInput.setError(null);
    }

    protected abstract IAccountRegistrationPresenter getPresenter();

}
