package com.example.darte.petroguide.presenter;

import android.app.Application;
import com.example.darte.petroguide.presenter.dagger.AppComponent;
import com.example.darte.petroguide.presenter.dagger.AppModule;
import com.example.darte.petroguide.presenter.dagger.DaggerAppComponent;

public class PGApplication extends Application {

    AppComponent appComponent;

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
