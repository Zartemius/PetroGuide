package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.domain.interactor.DbSynchronization;
import com.example.darte.petroguide.presenter.domain.interactor.PlacesLoading;
import com.example.darte.petroguide.presenter.navigation.SplashScreenRouter;
import com.example.darte.petroguide.presenter.presentation.mainscreen.BottomSheetPresenter;
import com.example.darte.petroguide.presenter.presentation.mainscreen.MainMapPresenter;
import com.example.darte.petroguide.presenter.presentation.splashscreen.SplashScreenPresenter;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
class PresenterModule {

    @Singleton
    @Provides
    MainMapPresenter provideMapPresenter(PlacesLoading placesLoading){
        MainMapPresenter mainMapPresenter = new MainMapPresenter(placesLoading);
        return mainMapPresenter;
    }

    @Singleton
    @Provides
    SplashScreenPresenter provideSplashPresenter(DbSynchronization dbSynchronization, SplashScreenRouter splashScreenRouter){
        SplashScreenPresenter splashScreenPresenter = new SplashScreenPresenter(dbSynchronization,splashScreenRouter);
        return splashScreenPresenter;
    }

    @Singleton
    @Provides
    BottomSheetPresenter provideBottomSheetPresenter(PlacesLoading placesLoading){
        BottomSheetPresenter bottomSheetPresenter = new BottomSheetPresenter(placesLoading);
        return bottomSheetPresenter;
    }
}
