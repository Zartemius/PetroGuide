package com.example.darte.petroguide.presenter.presentation.splashscreen;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.example.darte.petroguide.R;
import com.example.darte.petroguide.presenter.PGApplication;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;
import javax.inject.Inject;

public class SplashScreen extends AppCompatActivity implements SplashView {

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

    private void checkPermissionForGettingUserLocation() {
        if (ContextCompat.checkSelfPermission(
                    this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermission();
        }else{
            mSplashScreenPresenter.updateDataInDbAndGetToTheNextScreen();
        }
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},111);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            mSplashScreenPresenter.updateDataInDbAndGetToTheNextScreen();
        }else{
            handlePermissionDenied();
            //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            Log.i("PERMISSION_RESPONSE","was_granted");
        }
    }

    private void handlePermissionDenied(){

        boolean userWantsToBeAskedAboutPermissionAgain = ActivityCompat
                .shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION);

        if(userWantsToBeAskedAboutPermissionAgain){
            showWarningMessage();
            requestPermission();
        }else{
            mSplashScreenPresenter.updateDataInDbAndGetToTheNextScreen();
        }
    }

    @Override
    public void onBackPressed() {
        mSplashScreenPresenter.onBackPressed();
    }

    public void showWarningMessage(){
        Toast.makeText(this,
                R.string.permission_warning,
                Toast.LENGTH_LONG).show();
    }
}
