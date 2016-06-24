package com.example.binding.models;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class SignInModelDB extends BaseObservable {

    @NonNull
    private String email;
    @NonNull
    private String password;

    public SignInModelDB(@NonNull final String email, @NonNull final String password) {
        this.email = email;
        this.password = password;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull final String email) {
        this.email = email;
        notifyChange();
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull final String password) {
        this.password = password;
        notifyChange();
    }

    public boolean isInputDataValid() {
        return isValidEmail(getEmail()) && (!TextUtils.isEmpty(getPassword()) && getPassword().length() > 6);
    }

    private final boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
