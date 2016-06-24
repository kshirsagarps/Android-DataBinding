package com.example.binding.models;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SignInViewModelTest {
    private SignInViewModel.SignInListener dataListener;
    private SignInViewModel signInViewModel;

    @Before
    public void setUp() {
        dataListener = Mockito.mock(SignInViewModel.SignInListener.class);
        signInViewModel = new SignInViewModel(dataListener);
    }

    @Test
    public void testOnClick() throws Exception {
        signInViewModel.onSignInClick(Mockito.mock((View.class)));
        verify(dataListener, times(1)).onSignInCompleted();

        signInViewModel.onSignUpClick(Mockito.mock((View.class)));
        verify(dataListener, times(1)).onSignUpClicked();
    }
}