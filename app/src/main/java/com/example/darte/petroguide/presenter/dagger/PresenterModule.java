package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.map.MapPresenter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class PresenterModule {
    @Provides
    @Singleton
    MapPresenter provideMapPresenter(){
        MapPresenter mapPresenter = new MapPresenter();
        return mapPresenter;
    }
}
