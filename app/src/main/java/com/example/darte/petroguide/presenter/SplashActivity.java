package com.example.darte.petroguide.presenter;

import android.app.Application;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.darte.petroguide.presenter.data.DbSynchronization;
import com.example.darte.petroguide.presenter.menu.MenuActivity;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {

    @Inject
    DbSynchronization dbSynchronization;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.splash_activity);

        if(dbSynchronization != null) {
            dbSynchronization.synchronizeDb();
        }

        Intent launchAcitivty = new Intent(this,MenuActivity.class);
        startActivity(launchAcitivty);


    }

}
