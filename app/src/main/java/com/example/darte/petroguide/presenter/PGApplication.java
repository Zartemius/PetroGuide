package com.example.darte.petroguide.presenter;

import android.app.Application;
import android.content.Context;
import com.example.darte.petroguide.presenter.dagger.AppComponent;
import com.example.darte.petroguide.presenter.dagger.AppModule;
import com.example.darte.petroguide.presenter.dagger.DaggerAppComponent;
import com.example.darte.petroguide.presenter.domain.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PGApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    public AppComponent initDagger(PGApplication app){
        return DaggerAppComponent.builder()
                    .appModule(new AppModule(app))
                    .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
