package com.example.binding.models;

import android.databinding.BaseObservable;
import android.databinding.Observable;

import com.example.binding.BR;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SignInModelDBTest {

    SignInModelDB signInModelDB;
    BaseObservable.OnPropertyChangedCallback propertyChangedCallback;

    @Before
    public void Setup() {
        propertyChangedCallback = Mockito.mock(Observable.OnPropertyChangedCallback.class);
        signInModelDB = new SignInModelDB("", "");
        signInModelDB.addOnPropertyChangedCallback(propertyChangedCallback);
    }

    @Test
    public void testPropertyChange() {
        signInModelDB.setEmail("test@test.com");
        verify(propertyChangedCallback, times(1)).onPropertyChanged(signInModelDB, BR._all);

        signInModelDB.setPassword("password");
        verify(propertyChangedCallback, times(2)).onPropertyChanged(signInModelDB, BR._all);
    }
}
