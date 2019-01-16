package com.example.darte.petroguide.presenter.presentation.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.darte.petroguide.presenter.PGApplication;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity implements SplashActivityView {

    @Inject SplashScreenPresenter mSplashScreenPresenter;
    private Navigator mNavigator = new SupportAppNavigator(this,-1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_activity);
        ((PGApplication) getApplication()).getAppComponent().inject(this);
        mSplashScreenPresenter.updateDataInDb();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mSplashScreenPresenter.subscribe(this);
        mSplashScreenPresenter.setNavigator(mNavigator);
    }

    @Override
    protected void onPause() {
        mSplashScreenPresenter.unsubscribe();
        mSplashScreenPresenter.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        mSplashScreenPresenter.onBackPressed();
    }
}
