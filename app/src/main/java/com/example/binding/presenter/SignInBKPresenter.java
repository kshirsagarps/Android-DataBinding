package com.example.binding.presenter;

import com.example.binding.models.SignInBKView;

/**
 * Created by pratyush on 6/19/16.
 */
public class SignInBKPresenter {

    private SignInBKView view;

    public SignInBKPresenter(SignInBKView view) {
        this.view = view;
    }

    public void sgnInRequest() {
        view.signInCompleted();
    }
}
