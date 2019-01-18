package com.example.darte.petroguide.presenter.presentation.splashscreen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
        checkPermissionForGettingUserLocation();
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

    public void checkPermissionForGettingUserLocation() {
        if (ContextCompat.checkSelfPermission(
                    this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermission();
        }
    }


    public void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},111);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            mSplashScreenPresenter.updateDataInDb();
        }else{
            Log.i("PERMISSION_MISTAKE","error");
        }
    }

    @Override
    public void onBackPressed() {
        mSplashScreenPresenter.onBackPressed();
    }
}
