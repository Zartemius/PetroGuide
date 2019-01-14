package com.example.darte.petroguide.presenter.presentation.splashscreen;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.darte.petroguide.presenter.PGApplication;
import com.example.darte.petroguide.presenter.presentation.menu.MenuActivity;
import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements SplashActivityView {

    @Inject SplashPresenter splashPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_activity);
        ((PGApplication) getApplication()).getAppComponent().inject(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        splashPresenter.subscribe(this);
        Intent launchAcitivty = new Intent(this,MenuActivity.class);
        startActivity(launchAcitivty);
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashPresenter.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }
}
