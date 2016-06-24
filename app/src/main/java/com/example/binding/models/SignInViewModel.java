package com.example.binding.models;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class SignInViewModel {

    public SignInModelDB signInModel;
    private SignInListener dataListener;

    public SignInViewModel(@NonNull final SignInListener signInDataListener) {
        dataListener = signInDataListener;
        signInModel = new SignInModelDB("", "");
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
                signInModel.setEmail(editable.toString().trim());
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
                signInModel.setPassword(editable.toString().trim());
            }
        };
    }

    public void onSignInClick(@NonNull final View view) {
        requestSignIn();
    }

    private void requestSignIn() {
        // Try emulating sign-in and tell the client its completed.
        dataListener.onSignInCompleted();
    }

    public void onSignUpClick(@NonNull final View view) {
        dataListener.onSignUpClicked();
    }

    public interface SignInListener {
        void onSignInCompleted();
        void onSignUpClicked();
    }
}
