package com.example.binding.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.binding.R;
import com.example.binding.models.SignInBKView;
import com.example.binding.presenter.SignInBKPresenter;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SignInFragmentBK extends Fragment implements SignInBKView {

    private static final float ALPHA_ENABLE = 1.0f;
    private static final float ALPHA_DISABLE = 0.5f;

    private Unbinder unBinder;
    private SignInBKPresenter presenter;

    @BindString(R.string.signin_completed) String signInCompletedMessage;
    @BindString(R.string.signup_clicked) String signUpClickedMessage;

    @BindView(R.id.edit_text_email) EditText emailET;
    @BindView(R.id.edit_text_password) EditText passwordET;
    @BindView(R.id.button_signin) Button signinBT;
    @BindView(R.id.button_signup) Button signupBT;

    @OnClick(R.id.button_signin)
    public void singInClick() {
        presenter.sgnInRequest();
    }

    @OnClick(R.id.button_signup)
    public void signUpClick() {
        Toast.makeText(getActivity(), signUpClickedMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_sign_in_bk, container, false);
        unBinder = ButterKnife.bind(this, rootView);
        presenter = new SignInBKPresenter(this);
        emailET.addTextChangedListener(getEmailTextWatcher());
        passwordET.addTextChangedListener(getPasswordTextWatcher());
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unBinder.unbind();
    }

    @Override
    public void signInCompleted() {
        // Start main screen
        Toast.makeText(getActivity(), signInCompletedMessage, Toast.LENGTH_LONG).show();
    }

    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(@NonNull final Editable editable) {
                isInputDataValid();
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(@NonNull final Editable editable) {
                isInputDataValid();
            }
        };
    }

    public void isInputDataValid() {
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        if (isValidEmail(email) &&
                (!TextUtils.isEmpty(password) && password.length() > 6)) {
            signinBT.setAlpha(ALPHA_ENABLE);
            signinBT.setEnabled(true);
        } else {
            signinBT.setAlpha(ALPHA_DISABLE);
            signinBT.setEnabled(false);
        }
    }

    private final boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) &&
                Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}