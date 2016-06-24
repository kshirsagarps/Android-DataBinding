package com.example.binding.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.binding.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchBKActivity(@NonNull View view) {
        startActivity(new Intent(this, BKActivity.class));
    }

    public void launchDBActivity(@NonNull View view) {
        startActivity(new Intent(this, DBActivity.class));
    }
}
