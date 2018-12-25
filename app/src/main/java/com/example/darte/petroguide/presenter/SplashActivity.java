package com.example.darte.petroguide.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.menu.MenuActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        startActivity(new Intent(this,MenuActivity.class));
    }
}
