package com.example.darte.petroguide.presenter.presentation.splashscreen;

import android.util.Log;
import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;

import javax.inject.Inject;

public class SplashPresenter {

    private DbSynchronization mDbSynchronization;
    private SplashActivityView mSplashActivityView = null;

    @Inject
    public SplashPresenter(DbSynchronization dbSynchronization){
       mDbSynchronization = dbSynchronization;
    }

    void subscribe(SplashActivityView splashActivityView){
        Log.i("PRESENTER_WORKS", "true");
        mSplashActivityView = splashActivityView;
        updateDataInDb();
    }

    void unsubscribe(){
        mSplashActivityView = null;
    }

    private void updateDataInDb(){
        mDbSynchronization.synchronizeAppDbWithCloudDb();
    }
}


