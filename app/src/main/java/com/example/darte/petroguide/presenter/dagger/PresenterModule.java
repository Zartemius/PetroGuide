package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import com.example.darte.petroguide.presenter.presentation.mapscreen.MapPresenter;
import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashPresenter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class PresenterModule {

    @Singleton
    @Provides
    MapPresenter provideMapPresenter(){
        MapPresenter mapPresenter = new MapPresenter();
        return mapPresenter;
    }

    @Singleton
    @Provides
    SplashPresenter provideSplashPresenter(DbSynchronization dbSynchronization){
        SplashPresenter splashPresenter = new SplashPresenter(dbSynchronization);
        return splashPresenter;
    }
}
