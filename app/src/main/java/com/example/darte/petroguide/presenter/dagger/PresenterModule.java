package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.navigation.SplashScreenRouter;
import com.example.darte.petroguide.presenter.presentation.mainscreen.MapPresenter;
import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashScreenPresenter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class PresenterModule {

    @Singleton
    @Provides
    MapPresenter provideMapPresenter(PlacesLoading placesLoading){
        MapPresenter mapPresenter = new MapPresenter(placesLoading);
        return mapPresenter;
    }

    @Singleton
    @Provides
    SplashScreenPresenter provideSplashPresenter(DbSynchronization dbSynchronization, SplashScreenRouter splashScreenRouter){
        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(dbSynchronization,splashScreenRouter);
        return splashScreenPresenter;
    }
}
