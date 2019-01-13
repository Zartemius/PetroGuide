package com.example.darte.petroguide.presenter;

import android.app.Application;
import android.content.Context;
import com.example.darte.petroguide.presenter.dagger.AppComponent;
import com.example.darte.petroguide.presenter.dagger.AppModule;
import com.example.darte.petroguide.presenter.dagger.DaggerAppComponent;

public class PGApplication extends Application {

    AppComponent appComponent;
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        PGApplication.application= this;

        appComponent = initDagger(this);
    }

    public AppComponent initDagger(PGApplication app){
        return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
    }

    public static Application getApp(){
        return application;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
