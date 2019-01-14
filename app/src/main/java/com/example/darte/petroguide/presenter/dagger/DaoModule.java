package com.example.darte.petroguide.presenter.dagger;

import com.example.darte.petroguide.presenter.data.appdatabase.AppDataBase;
import com.example.darte.petroguide.presenter.data.appdatabase.PlaceDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class DaoModule {

    @Singleton
    @Provides
    PlaceDao providePlaceDao(AppDataBase appDataBase){
        return appDataBase.placeDao();
    }
}
