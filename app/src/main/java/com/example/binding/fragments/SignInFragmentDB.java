package com.example.binding.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.binding.R;
import com.example.binding.models.SignInViewModel;
import com.example.binding.databinding.FragmentSignInDbBinding;

/**
 * Created by pratyush on 6/18/16.
 */

public class SignInFragmentDB extends Fragment implements SignInViewModel.SignInListener {

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View layout = inflater.inflate(R.layout.fragment_sign_in_db, container, false);
        FragmentSignInDbBinding.bind(layout)
                .setViewModel(new SignInViewModel(this));
        return layout;
    }

    @Override
    public void onSignInCompleted() {
        // Start main screen
        Toast.makeText(getActivity(), "Sign In Completed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignUpClicked() {
        // Start sign up screen
        Toast.makeText(getActivity(), "Sign Up Clicked", Toast.LENGTH_LONG).show();
    }
}

