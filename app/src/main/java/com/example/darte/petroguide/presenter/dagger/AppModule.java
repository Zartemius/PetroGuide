package com.example.darte.petroguide.presenter.dagger;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModule{

    private Application mApplication;

    public AppModule(Application app){
        mApplication = app;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mApplication;
    }
}
